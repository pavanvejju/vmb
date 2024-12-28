package com.vmb.enterprise.service;

import com.vmb.enterprise.model.MessageItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.BiFunction;
import java.util.function.Supplier;

@Service
public class KafkaProducerService {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaProducerService.class);

    @Value("${spring.kafka.topic.message1}")
    private String topic1;

    @Value("${spring.kafka.topic.message2}")
    private String topic2;

    private static final String contentType = "application/json";
    private final BlockingQueue<MessageItem> messageQueue1 = new LinkedBlockingQueue<>();
    private final BlockingQueue<MessageItem> messageQueue2 = new LinkedBlockingQueue<>();

    @Bean
    public Supplier<Message<MessageItem>> produceMessage1() {
        return () ->{
            MessageItem messageItem = messageQueue1.poll();
            return produceMessage().apply(messageItem, topic1);
        };
    }

    @Bean
    public Supplier<Message<MessageItem>> produceMessage2() {
        return () ->{
            MessageItem messageItem = messageQueue2.poll();
            return produceMessage().apply(messageItem, topic2);
        };
    }

    @Bean
    public BiFunction<MessageItem, String, Message<MessageItem>> produceMessage() {
        return (messageItem,topic) -> {
            try {
                if (messageItem != null) {
                    return MessageBuilder.withPayload(messageItem)
                            .setHeader("contentType", contentType) // Example contentType
                            .setHeader("topic", topic)         // Example topic
                            .build();
                }
            } catch (Exception e) {
                LOG.error("Error processing message: {}", e.getMessage());
            }
            return null; // Return null if message processing fails
        };
    }

    public void send1(String message){
        MessageItem messageItem = new MessageItem(UUID.randomUUID().toString(), message, LocalDateTime.now().toString());
        messageQueue1.offer(messageItem);
    }

    public void send2(String message){
        MessageItem messageItem = new MessageItem(UUID.randomUUID().toString(), message, LocalDateTime.now().toString());
        messageQueue2.offer(messageItem);
    }
}