package com.websocket.chat.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.websocket.chat.model.ChatMessage;
import com.websocket.chat.model.ChatRoom;
import com.websocket.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@RequiredArgsConstructor
@Component
public class ChatHandler extends TextWebSocketHandler {

    private final ObjectMapper objectMapper;
    private final ChatService chatService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload {}", payload);
        //웹소켓 클라이언트로부터 채팅 메세지 전달받아 객체로 변환
        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
        //전달받은 메세지에 담긴 채팅방id로 발송 대상 채팅방 조회함
        ChatRoom room = chatService.findRoomById(chatMessage.getRoomId());
        //해당 채팅방에 입장해있는 session(클라이언트)들에게 타입에 따른 메세지 발송
        room.handleActions(session, chatMessage, chatService);
    }
}
