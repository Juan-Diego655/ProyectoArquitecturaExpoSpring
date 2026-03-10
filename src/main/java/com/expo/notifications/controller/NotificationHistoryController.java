package com.expo.notifications.controller;

import com.expo.notifications.model.NotificationLog;
import com.expo.notifications.repository.NotificationLogRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NotificationHistoryController {

    private final NotificationLogRepository logRepository;

    public NotificationHistoryController(NotificationLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @GetMapping("/history")
    public List<NotificationLog> getHistory(@RequestParam String username) {
        return logRepository.findHistoryForUser(username);
    }
}