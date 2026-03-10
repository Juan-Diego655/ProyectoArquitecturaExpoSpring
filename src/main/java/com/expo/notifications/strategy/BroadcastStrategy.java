package com.expo.notifications.strategy;

import com.expo.notifications.model.NotificationMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class BroadcastStrategy implements NotificationStrategy {

    private final SimpMessagingTemplate messagingTemplate;

    public BroadcastStrategy(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void send(NotificationMessage message) {
        messagingTemplate.convertAndSend("/topic/general", message.getContent());
    }
}