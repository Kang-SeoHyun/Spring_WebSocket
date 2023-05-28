package com.websocket.chat.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

// 기존 해쉬맵 사용하다 pub/sub 방식을 이용하여 구독자 관리가 알아서 되므로 세션 관리 필요 X
@Getter
@Setter
public class ChatRoom {
    private String roomId;
    private String name;

    public static ChatRoom create(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }
}
