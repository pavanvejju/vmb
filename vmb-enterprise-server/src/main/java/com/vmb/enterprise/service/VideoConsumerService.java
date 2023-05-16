package com.vmb.enterprise.service;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.function.Consumer;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.vmb.enterprise.dto.VideoDto;
import com.vmb.enterprise.utils.CustomUtils;


@Service
public class VideoConsumerService {
	
	private final Logger log = LoggerFactory.getLogger(VideoConsumerService.class);
	
	@Value("${bootstrapServers:localhost:9092}")
	private String bootstrapServers;
	 
	@Value("${spring.kafka.consumer.group-id:bi_vs_consumer}")
	private String groupId;
	@Value("${parent_video_folder:/tmp/stream/}")
	private String parentFolder;
	
	@Autowired
	private S3Service s3Service;
	
	File file = null;
    KafkaConsumer<String, VideoDto> consumer = null;
    Map<String,Object> tableMap	=	new HashMap<>();
//    String constructedFileName;
    
    String topic = "bi_vs_topic";
	
    
    public KafkaConsumer<String, VideoDto> prepareKafkaConsumerProperties() {
	    Properties props = new Properties();
	    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//	    props.put(ConsumerConfig.CLIENT_ID_CONFIG, CONSUMER_APP_ID);
	    props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
	    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
	    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
	    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "com.vmb.enterprise.utils.serdes.CustomDeserializer");
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 100);

	    return new KafkaConsumer<String, VideoDto>(props);
	}
    
    @PostConstruct
	public void createKafkaConsumer() {
		
		consumer = prepareKafkaConsumerProperties();
        consumer.subscribe(Arrays.asList(topic));
        final Thread mainThread = Thread.currentThread();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                log.info("Detected a shutdown, let's exit by calling consumer.wakeup()...");
                consumer.wakeup();
                try {
                    mainThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        consumer.subscribe(Arrays.asList(topic));
	}
    
    //@KafkaListener(id = "id", topics = "bi_vs_topic")
    public void listen(String in) {
        //log.info(in);
        readVideoStream();
        //prepareVideoStream(in);
    }
    
	public void readVideoStream() {
		try {
            while (true) {

            	ConsumerRecords<String, VideoDto> records = consumer.poll(Duration.ofSeconds(1));
                records.forEach(new Consumer<ConsumerRecord<String, VideoDto>>() {
					public void accept(ConsumerRecord<String, VideoDto> record) {
						VideoDto videoDto	=	record.value();
					    byte[] binary = java.util.Base64.getDecoder().decode(videoDto.getByteArryString());
					    if(!new File(parentFolder).isDirectory()) {
                			new File(parentFolder).mkdir();
                		}
					    System.out.print(videoDto.getCount()+",");
					    
					    if(!tableMap.containsKey(videoDto.getTableName()+"_file_name")) {
					    	tableMap.put(videoDto.getTableName()+"_file_name", null);
					    }
					    if(!tableMap.containsKey(videoDto.getTableName()+"_file")) {
					    	tableMap.put(videoDto.getTableName()+"_file", null);
					    }
					    
					    if(videoDto.getCount() == 0) {
					    	
					    	if( tableMap.get(videoDto.getTableName()+"_file")!=null &&  ((File)tableMap.get(videoDto.getTableName()+"_file")).exists()) {
		                			try {
										s3Service.uploadVideos(videoDto.getTableName()+"/"+tableMap.get(videoDto.getTableName()+"_file_name"), file);
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
					    	}
					    	
					    	String subFolder	=	parentFolder+videoDto.getTableName();
	                		if(!new File(subFolder).isDirectory()) {
	                			new File(subFolder).mkdir();
	                		}
	                		tableMap.put(videoDto.getTableName()+"_file_name", CustomUtils.prepareVideoFileName());
//	                		constructedFileName	=	CustomUtils.prepareVideoFileName();
	                		String filePath	=	subFolder+"/"+tableMap.get(videoDto.getTableName()+"_file");
	                		System.out.println("filePath>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+filePath);
	                		if(!new File(filePath).isFile()) {
	                			tableMap.put(videoDto.getTableName()+"_file", new File(filePath));
	                			log.info(filePath);
	                		}
					    }
	                	
	                	try {
	                		if(tableMap.get(videoDto.getTableName()+"_file") != null)
	                			FileUtils.writeByteArrayToFile((File)tableMap.get(videoDto.getTableName()+"_file"), binary, true);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
                

            }
        } catch (WakeupException e) {
            log.info("Wake up exception!");
        } catch (Exception e) {
//            log.error("Unexpected exception", e.getMessage());
            e.printStackTrace();
        } finally {
//            consumer.close(); // this will also commit the offsets if need be.
            log.info("The consumer is now gracefully closed.");
        }
	}
	
    public void prepareVideoStream(String videoDtoStr) {
    	
    	Gson g = new Gson();  
    	VideoDto videoDto = g.fromJson(videoDtoStr, VideoDto.class);

		
	    byte[] binary = java.util.Base64.getDecoder().decode(videoDto.getByteArryString());
	    if(!new File(parentFolder).isDirectory()) {
			new File(parentFolder).mkdir();
		}
	    System.out.print(videoDto.getCount()+",");
	   
	    if(!tableMap.containsKey(videoDto.getTableName())) {
	    	tableMap.put(videoDto.getTableName(), null);
	    }
	    String fileExists	=	(String)tableMap.get(videoDto.getTableName());
	    if(fileExists==null) {
	    	String subFolder	=	parentFolder+videoDto.getTableName();
    		if(!new File(subFolder).isDirectory()) {
    			new File(subFolder).mkdir();
    		}
    		String constructedFileName	=	CustomUtils.prepareVideoFileName();
    		String filePath	=	subFolder+"/"+constructedFileName;
    		log.info("FilePath>>>1111>>"+filePath);
    		if(!new File(filePath).isFile()) {
    			file = new File(filePath);
    			log.info("FilePath>>>2222>>"+filePath);
    		}
    		tableMap.put(videoDto.getTableName(), constructedFileName);
	    }
    	
    	try {
    		
    		 if(file != null) {
             	FileUtils.writeByteArrayToFile(file, binary, true);
             	if(videoDto.getCount() == 0) {
             		s3Service.uploadVideos(videoDto.getTableName()+"/"+(String)tableMap.get(videoDto.getTableName()), file);
             		tableMap.put(videoDto.getTableName(), null);
             	}
    		 }
    			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
    }

}
