package com.vmb.enterprise.component;

import com.vmb.enterprise.model.MessageItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import java.util.function.Function;

@Configuration
public class KafkaMessageListener {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaMessageListener.class);

   /* @KafkaListener(topics = "${spring.kafka.topic.message}")
    public void receive(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) int partition
           ){
        LOG.info("Kafka: receiver 1 message Payload = {} \ntopic={} \n partition={}", message,topic,partition );
       // messagingTemplate.convertAndSend("/topic.socket.kafka", messageItem);
    }*/

    @Bean
    public Consumer<MessageItem> firstConsumer() {
        return message -> LOG.info("First Consumer received: " + message);
    }

    @Bean
    public Consumer<MessageItem> secondConsumer() {
        return message -> LOG.info("Second Consumer received: " + message);
    }

    @Bean
    public Function<String, String> transformMessage() {
        return message -> "Transformed: " + message;
    }
}