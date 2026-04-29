package com.pravin.kafka.controller;

import com.pravin.kafka.entity.Notification;
import com.pravin.kafka.service.NotificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public Notification send(@RequestBody Notification notification) {
        return service.send(notification);
    }
}