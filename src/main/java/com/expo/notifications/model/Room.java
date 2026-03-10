package com.expo.notifications.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String createdBy;

    public Room() {}

    public Room(String name, String createdBy) {
        this.name = name;
        this.createdBy = createdBy;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCreatedBy() { return createdBy; }
}