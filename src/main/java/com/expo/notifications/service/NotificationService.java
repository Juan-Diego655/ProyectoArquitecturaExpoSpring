package com.expo.notifications.service;

import com.expo.notifications.model.NotificationMessage;
import com.expo.notifications.model.NotificationLog;
import com.expo.notifications.repository.NotificationLogRepository;
import com.expo.notifications.strategy.NotificationStrategy;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private NotificationStrategy strategy;
    private final NotificationLogRepository logRepository;

    public NotificationService(NotificationLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void send(NotificationMessage message) {
        strategy.send(message);

        // Guardar en base de datos
        NotificationLog log = new NotificationLog(
            message.getType(),
            message.getContent(),
            message.getRoom(),
            message.getUsername(),
            message.getSender()
        );
        logRepository.save(log);
    }
}