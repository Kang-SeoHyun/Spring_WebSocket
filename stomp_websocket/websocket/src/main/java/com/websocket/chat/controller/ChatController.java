package com.websocket.chat.controller;

import com.websocket.chat.model.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
//클라이언트로부터 메세지 받으면 처리하는 놈
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;

    //@* 통해서 websocket 으로 들어오는 메세지 발행을 처리함
    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if (ChatMessage.MessageType.ENTER.equals(message.getType()))
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        //"/sub/chat/room/" + message.getRoomId() 가 채팅룸을 구분하는 값이므로 topic 의 역할이라 보면 됨.
        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }
}
