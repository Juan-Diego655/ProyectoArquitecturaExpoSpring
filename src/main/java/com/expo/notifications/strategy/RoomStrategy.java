package com.expo.notifications.strategy;

import com.expo.notifications.model.NotificationMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class RoomStrategy implements NotificationStrategy {

    private final SimpMessagingTemplate messagingTemplate;

    public RoomStrategy(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void send(NotificationMessage message) {

        messagingTemplate.convertAndSend(
                "/topic/room/" + message.getRoom(),
                message.getContent()
        );
    }
}