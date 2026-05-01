package com.pravin.dashboard.repository;

import com.pravin.dashboard.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}