package com.vmb.enterprise.utils;

import java.util.Map;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomSerializer  implements Serializer<String> {

	private static final Logger log = LoggerFactory.getLogger(CustomSerializer.class);
	private final ObjectMapper objectMapper = new ObjectMapper();

    public void configure(Map<String, ?> configs, boolean isKey) {
    }
	@Override
	public byte[] serialize(String topic, String data) {
		
		try {
			if (data == null){
                log.info("Null received at serializing");
                return null;
            }
			return objectMapper.writeValueAsBytes(data);
			
		} catch (Exception e) {
			throw new SerializationException("Error when serializing MessageDto to byte[]");
		}
	}
    public void close() {
    }
}
