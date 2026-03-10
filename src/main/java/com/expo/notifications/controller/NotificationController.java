package com.expo.notifications.controller;

import com.expo.notifications.model.NotificationMessage;
import com.expo.notifications.service.NotificationService;
import com.expo.notifications.strategy.BroadcastStrategy;
import com.expo.notifications.strategy.PrivateStrategy;
import com.expo.notifications.strategy.RoomStrategy;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {

    private final NotificationService service;

    private final BroadcastStrategy broadcastStrategy;
    private final RoomStrategy roomStrategy;
    private final PrivateStrategy privateStrategy;

    public NotificationController(
            NotificationService service,
            BroadcastStrategy broadcastStrategy,
            RoomStrategy roomStrategy,
            PrivateStrategy privateStrategy) {

        this.service = service;
        this.broadcastStrategy = broadcastStrategy;
        this.roomStrategy = roomStrategy;
        this.privateStrategy = privateStrategy;
    }

    @MessageMapping("/notify")
    public void sendNotification(NotificationMessage message) {

        switch (message.getType()) {

            case "broadcast":
                service.setStrategy(broadcastStrategy);
                break;

            case "room":
                service.setStrategy(roomStrategy);
                break;

            case "private":
                service.setStrategy(privateStrategy);
                break;
        }

        service.send(message);
    }
}