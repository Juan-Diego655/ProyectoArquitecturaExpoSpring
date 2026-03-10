package com.expo.notifications.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notification_log")
public class NotificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String content;
    private String room;
    private String username;
    private String sender;

    private LocalDateTime timestamp;

    public NotificationLog() {}

    public NotificationLog(String type, String content, String room, String username, String sender) {
        this.type = type;
        this.content = content;
        this.room = room;
        this.username = username;
        this.sender = sender;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getType() { return type; }
    public String getContent() { return content; }
    public String getRoom() { return room; }
    public String getUsername() { return username; }
    public String getSender() { return sender; }
    public LocalDateTime getTimestamp() { return timestamp; }
}