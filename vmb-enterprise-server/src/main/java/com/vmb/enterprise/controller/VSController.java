package com.vmb.enterprise.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neovisionaries.ws.client.WebSocketException;
import com.vmb.enterprise.dto.VideoRequestDto;
import com.vmb.enterprise.model.MessageItem;
import com.vmb.enterprise.service.KafkaProducerService;
import com.vmb.enterprise.service.VideoProducerService;

@RestController
@RequestMapping("api/v1/mq")
public class VSController {
	
	private static final Logger LOG = LoggerFactory.getLogger(VSController.class);
	
	@Autowired
	private VideoProducerService videoProducerService;
	
	 @Autowired
	 private KafkaProducerService kafkaProducerService;
	
	
	//@ApiOperation(value = "fetch video streaming from url and push it to kafka")
	@RequestMapping(method = RequestMethod.POST, value = "pushVideoStreaming")
	public void produceVideoStreaming(@RequestBody VideoRequestDto videoRequestDto ) {
		try {
			videoProducerService.connectToVideoSocket(videoRequestDto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WebSocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	 @RequestMapping(value = "/publish_kafka", method = RequestMethod.POST)
	    public String sendMessageToKafkaConsumer(@RequestParam String message){
	        MessageItem messageItem = new MessageItem();
	        messageItem.setMessage(message);
	        messageItem.setUuid(UUID.randomUUID().toString());
	        messageItem.setTime(LocalDateTime.now().toString());

	        LOG.info("New message: '{}'", messageItem);
	        kafkaProducerService.send(messageItem);
	        return "redirect:kafka_producer.html";
	    }
	 
	 @RequestMapping("/")  
	 public String hello()   
	 {  
	 return "Hello User";  
	 }  
	
	
	
}
