package com.expo.notifications.repository;

import com.expo.notifications.model.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {

    @Query("SELECT n FROM NotificationLog n WHERE " +
           "n.type = 'broadcast' OR " +
           "n.username = :username OR " +
           "n.sender = :username OR " +
           "n.room IN (SELECT ur.roomName FROM UserRoom ur WHERE ur.username = :username) " +
           "ORDER BY n.timestamp ASC")
    List<NotificationLog> findHistoryForUser(@Param("username") String username);
}