package com.expo.notifications.controller;

import com.expo.notifications.model.UserRoom;
import com.expo.notifications.repository.UserRoomRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user-rooms")
public class UserRoomController {

    private final UserRoomRepository userRoomRepository;

    public UserRoomController(UserRoomRepository userRoomRepository) {
        this.userRoomRepository = userRoomRepository;
    }

    @GetMapping("/{username}")
    public List<UserRoom> getUserRooms(@PathVariable String username) {
        return userRoomRepository.findByUsername(username);
    }

    @PostMapping
    public UserRoom joinRoom(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String roomName = body.get("roomName");
        if (userRoomRepository.existsByUsernameAndRoomName(username, roomName)) {
            return userRoomRepository.findByUsername(username)
                .stream()
                .filter(r -> r.getRoomName().equals(roomName))
                .findFirst().orElseThrow();
        }
        return userRoomRepository.save(new UserRoom(username, roomName));
    }

    @DeleteMapping
    @Transactional
    public void leaveRoom(@RequestBody Map<String, String> body) {
        userRoomRepository.deleteByUsernameAndRoomName(
            body.get("username"), body.get("roomName")
        );
    }
}