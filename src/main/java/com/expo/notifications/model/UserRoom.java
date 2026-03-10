package com.expo.notifications.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_rooms")
public class UserRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String roomName;

    public UserRoom() {}

    public UserRoom(String username, String roomName) {
        this.username = username;
        this.roomName = roomName;
    }

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getRoomName() { return roomName; }
}