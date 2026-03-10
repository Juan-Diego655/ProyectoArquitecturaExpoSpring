package com.expo.notifications.controller;

import com.expo.notifications.model.Room;
import com.expo.notifications.repository.RoomRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @PostMapping
    public Room createRoom(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        String createdBy = body.get("createdBy");
        if (roomRepository.existsByName(name)) {
            return roomRepository.findAll()
                .stream()
                .filter(r -> r.getName().equals(name))
                .findFirst().orElseThrow();
        }
        return roomRepository.save(new Room(name, createdBy));
    }
}