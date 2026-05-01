package com.pravin.dashboard.controller;

import com.pravin.dashboard.dto.NotificationRequest;
import com.pravin.dashboard.dto.NotificationResponse;
import com.pravin.dashboard.service.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public NotificationResponse send(@RequestBody NotificationRequest notification) {
        return service.send(notification);
    }
}