package com.pravin.dashboard.repository;

import com.pravin.dashboard.entity.KafkaFailedMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KafkaFailedMessageRepository extends JpaRepository<KafkaFailedMessage, Long> {
}
