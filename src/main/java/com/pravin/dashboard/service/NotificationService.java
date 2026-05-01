package com.pravin.dashboard.service;
import com.pravin.dashboard.component.DataMapper;
import com.pravin.dashboard.dto.NotificationRequest;
import com.pravin.dashboard.dto.NotificationResponse;
import com.pravin.dashboard.entity.Notification;
import com.pravin.dashboard.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationRepository repo;
    private final DataMapper dataMapper;

    public NotificationService(NotificationRepository repo, DataMapper dataMapper) {
        this.repo = repo;
        this.dataMapper = dataMapper;
    }

    public NotificationResponse send(NotificationRequest notificationRequest) {
        Notification notification = dataMapper.toEntity(notificationRequest);
        notification.setStatus("SENT");
        return dataMapper.toResponse(repo.save(notification));
    }
}