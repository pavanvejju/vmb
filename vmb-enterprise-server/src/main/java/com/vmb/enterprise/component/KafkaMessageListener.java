package com.vmb.enterprise.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.vmb.enterprise.model.MessageItem;

@Component
public class KafkaMessageListener {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "${spring.kafka.topic.message}")
    public void receive(MessageItem messageItem){
        LOG.info("Kafka: Received message = {}", messageItem);
       // messagingTemplate.convertAndSend("/topic.socket.kafka", messageItem);
    }
}
