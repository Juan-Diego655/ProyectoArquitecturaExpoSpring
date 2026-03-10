package com.expo.notifications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NotificationsApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(NotificationsApplication.class, args);
        
        // Imprimir todos los beans registrados
        String[] beans = ctx.getBeanDefinitionNames();
        for (String bean : beans) {
            if (bean.toLowerCase().contains("websocket") || 
                bean.toLowerCase().contains("stomp") ||
                bean.toLowerCase().contains("sockjs")) {
                System.out.println("BEAN ENCONTRADO: " + bean);
            }
        }
    }
}