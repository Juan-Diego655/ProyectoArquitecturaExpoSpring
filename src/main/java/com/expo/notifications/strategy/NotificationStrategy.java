package com.expo.notifications.strategy;

import com.expo.notifications.model.NotificationMessage;

public interface NotificationStrategy {

    void send(NotificationMessage message);

}