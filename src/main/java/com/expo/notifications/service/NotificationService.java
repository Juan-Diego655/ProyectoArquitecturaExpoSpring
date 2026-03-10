package com.expo.notifications.service;

import com.expo.notifications.model.NotificationMessage;
import com.expo.notifications.strategy.NotificationStrategy;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private NotificationStrategy strategy;

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void send(NotificationMessage message) {
        strategy.send(message);
    }
}