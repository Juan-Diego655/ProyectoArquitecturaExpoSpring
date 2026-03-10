package com.expo.notifications.strategy;

import com.expo.notifications.model.NotificationMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class PrivateStrategy implements NotificationStrategy {

    private final SimpMessagingTemplate messagingTemplate;

    public PrivateStrategy(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void send(NotificationMessage message) {

        messagingTemplate.convertAndSendToUser(
                message.getUsername(),
                "/queue/private",
                message.getContent()
        );
    }
}