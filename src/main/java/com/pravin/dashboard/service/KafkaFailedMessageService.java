package com.pravin.dashboard.service;

import com.pravin.dashboard.entity.KafkaFailedMessage;
import com.pravin.dashboard.repository.KafkaFailedMessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KafkaFailedMessageService {

    private final KafkaFailedMessageRepository kafkaFailedMessageRepository;

    public KafkaFailedMessageService(KafkaFailedMessageRepository kafkaFailedMessageRepository){
        this.kafkaFailedMessageRepository= kafkaFailedMessageRepository;
    }

    @Transactional
    public KafkaFailedMessage save(KafkaFailedMessage kafkaFailedMessage){
        return kafkaFailedMessageRepository.save(kafkaFailedMessage);
    }

}
