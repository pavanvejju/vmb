package com.vmb.enterprise.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.vmb.enterprise.model.MessageItem;

@Component
public class KafkaMessageListener {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "${spring.kafka.topic.message}")
    public void receive(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) int partition
           ){
        LOG.info("Kafka: Received message = {}", message);
       // messagingTemplate.convertAndSend("/topic.socket.kafka", messageItem);
    }
}
