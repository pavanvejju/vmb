package com.vmb.enterprise.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	
	@PostMapping(value = "/publish_kafka1")
	public String publishKafkaMessage1(@RequestParam String message){
		MessageItem messageItem = new MessageItem(UUID.randomUUID().toString(),message,LocalDateTime.now().toString());
		LOG.info("New message to topic1: '{}'", messageItem);
		kafkaProducerService.send1(messageItem);
		return "Successfully sent message to topic 1";
	}

	@PostMapping(value = "/publish_kafka2")
	public String publishKafkaMessage2(@RequestParam String message){
		MessageItem messageItem = new MessageItem(UUID.randomUUID().toString(),message,LocalDateTime.now().toString());
		LOG.info("New message to topic2: '{}'", messageItem);
		kafkaProducerService.send2(messageItem);
		return "Successfully sent message to topic 2";
	}
	 
	 @RequestMapping("/")  
	 public String hello()   
	 {  
	 return "Hello User";  
	 }
}
