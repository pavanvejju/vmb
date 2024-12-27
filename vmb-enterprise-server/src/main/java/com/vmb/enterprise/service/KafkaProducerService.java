package com.vmb.enterprise.service;

import com.vmb.enterprise.model.MessageItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaProducerService.class);

    @Value("${spring.kafka.topic.message1}")
    private String topic1;

    @Value("${spring.kafka.topic.message2}")
    private String topic2;

    @Autowired
    private KafkaTemplate<String, MessageItem> kafkaTemplate;

    public void send1(MessageItem messageItem){
        LOG.info("Sent By Kafka topic 1");
        kafkaTemplate.send(topic1, messageItem);
    }

    public void send2(MessageItem messageItem){
        LOG.info("Sent By Kafka topic 2");
        kafkaTemplate.send(topic2, messageItem);
    }

    /*@Bean
    public Supplier<String> messageSupplier() {
        return ()->"test supplier";
    }*/
}