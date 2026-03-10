package com.expo.notifications.repository;

import com.expo.notifications.model.UserRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRoomRepository extends JpaRepository<UserRoom, Long> {
    List<UserRoom> findByUsername(String username);
    boolean existsByUsernameAndRoomName(String username, String roomName);
    void deleteByUsernameAndRoomName(String username, String roomName);
}