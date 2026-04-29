package com.pravin.kafka.service;
import com.pravin.kafka.entity.Notification;
import com.pravin.kafka.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationRepository repo;

    public NotificationService(NotificationRepository repo) {
        this.repo = repo;
    }

    public Notification send(Notification notification) {
        notification.setStatus("SENT");
        return repo.save(notification);
    }
}