package com.vmb.enterprise.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.vmb.enterprise.model.MessageItem;

@Configuration
public class KafkaMessageConfig {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaMessageConfig.class);

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;
    
   

    @Bean
    public Map<String, Object> messageProducerConfig(){
        LOG.info("Setting Kafka Properties");
        Map<String, Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return properties;
    }
    
    @Bean
    public Map<String, Object> messageConsumerConfig(){
        LOG.info("Setting Kafka Properties");
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group_json");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return properties;
    }

    @Bean
    public ProducerFactory<String, MessageItem> producerFactory(){
        LOG.info("Creating Kafka ProducerFactory");
        return new DefaultKafkaProducerFactory<>(messageProducerConfig());
    }

    @Bean
    public KafkaTemplate<String, MessageItem> kafkaTemplate(){
        LOG.info("Creating Kafka Template");
        return new KafkaTemplate<>(producerFactory());
    }
    
    @Bean
    public ConsumerFactory<String, MessageItem> consumerFactory(){
        LOG.info("Creating Kafka ConsumerFactory");
        return new DefaultKafkaConsumerFactory<>(
                messageConsumerConfig(),
                new StringDeserializer(),
                new JsonDeserializer<>(MessageItem.class)
        );
    }
    
}
