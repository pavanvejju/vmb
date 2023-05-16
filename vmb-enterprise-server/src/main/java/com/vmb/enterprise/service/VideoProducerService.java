package com.vmb.enterprise.service;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFactory;
import com.neovisionaries.ws.client.WebSocketFrame;
import com.vmb.enterprise.dto.VideoDto;
import com.vmb.enterprise.dto.VideoRequestDto;
	

@Service
public class VideoProducerService {
    private static final Logger log = LoggerFactory.getLogger(VideoProducerService.class);
    
   // private String URL = "wss://ws.pragmaticplaylive.net/rla3";
    @Value("${bootstrapServers:localhost:9092}")
	private String bootstrapServers;
	
	public static List<String> ListMessage = new ArrayList<String>();
	public static boolean WebSocketLog = true;
	private static String flag = "true";
	private int loopCount = 0;
   // private final int max_loop_count = 10000;
    
    public KafkaProducer<String, VideoDto> prepareKafkaProduceProperties() {
	    Properties props = new Properties();
	    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//	    props.put(ProducerConfig.CLIENT_ID_CONFIG, CONSUMER_APP_ID);
	    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
	    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "com.vmb.enterprise.utils.serdes.CustomSerializer");
	    return new KafkaProducer(props);
	}
    
    private void pushDataToTopic(KafkaProducer<String, String> producer, ProducerRecord<String, String> producerRecord) {

            // create a producer record

            // send data - asynchronous
            producer.send(producerRecord, new Callback() {
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    // executes every time a record is successfully sent or an exception is thrown
                    if (e == null) {
                        // the record was successfully sent
                        log.info("Received new metadata. \n" +
                                "Topic:" + recordMetadata.topic() + "\n" +
                                "Partition: " + recordMetadata.partition() + "\n" +
                                "Offset: " + recordMetadata.offset() + "\n" +
                                "Timestamp: " + recordMetadata.timestamp());
                    } else {
                        log.error("Error while producing", e);
                    }
                }
            });
	        // flush data - synchronous
	        producer.flush();
	        // flush and close producer
	        producer.close();
    }

    public void connectToVideoSocket(VideoRequestDto videoRequestDto) throws IOException, WebSocketException {
			connect(videoRequestDto);
	}
    private int fileCount = 0;
    private File gFile = null;
    private WebSocket connect(VideoRequestDto videoRequestDto) throws IOException, WebSocketException {
        WebSocketFactory wsFactory = new WebSocketFactory().setConnectionTimeout(10*1000);
        WebSocket socket = wsFactory.createSocket(URI.create(videoRequestDto.getUrl())).addProtocol("json");
        socket.sendText(videoRequestDto.getQuality());
        socket.setPingInterval(videoRequestDto.getMinitues()*60*1000);
        socket.setMissingCloseFrameAllowed(false);
        
        final KafkaProducer<String, VideoDto> producer = prepareKafkaProduceProperties();
    	
        socket.addListener(new WebSocketAdapter() {
            @Override
            public void onSendingHandshake(WebSocket websocket, String requestLine, List<String[]> headers) {
                if (WebSocketLog) log.info(requestLine);
                for (String[] header : headers) { //Print the header, "{name}: {value}"
                    if (WebSocketLog) System.out.format("%s: %s\n", header[0], header[1]);
                }
            }
            @Override
            public void onConnected(WebSocket websocket, Map<String, List<String>> headers) {
                if (WebSocketLog) log.info("Success! WebSocket - Connected!");
            }
            
            @Override
            public void onDisconnected(WebSocket websocket, WebSocketFrame serverCloseFrame, WebSocketFrame clientCloseFrame, boolean closedByServer) {
                if (WebSocketLog) log.info("Disconnecting...");
                if (WebSocketLog) log.info(" Opcode: %d%n", serverCloseFrame.getOpcode());
            }
            @Override
            public void onPongFrame(WebSocket websocket, WebSocketFrame frame) {
                if (WebSocketLog) log.info("Received some pong..!! Payload text: %s", frame.getPayloadText());
                log.info(" Opcode: %d%n", frame.getOpcode());
               
   			    loopCount=0;
   			    /*
   			    gFile = new File("/tmp/video_streaming/video"+fileCount+".mp4");
			    fileCount++;
			    */
                websocket.sendText(videoRequestDto.getQuality());
            }
            @Override
            public void onPingFrame(WebSocket websocket, WebSocketFrame frame) {
                if (WebSocketLog) log.info("I have been pinged by server at %s%n", LocalDateTime.now());
                websocket.sendPong("Ponging from client");
            }
            @Override
            public void onTextFrame(WebSocket websocket, WebSocketFrame frame) {
                if (WebSocketLog) log.info("onTextFrame - %s%n", LocalDateTime.now());
                websocket.sendPong("onTextFrame from client");
                loopCount = 0;
            }
            @Override
            public void onError(WebSocket websocket, WebSocketException cause) {
                log.info("I have received exception %s%n", cause.getMessage());
            }
            @Override
            public void onBinaryMessage(final WebSocket websocket, byte[] binary) throws Exception
            {
            	if (binary.length > 0) {
            	/*
            		try {
                		if(gFile != null )
                			FileUtils.writeByteArrayToFile(gFile, binary, true);
					} catch (IOException e) {
						e.printStackTrace();
					}
					*/
            		VideoDto videoDto = new VideoDto();
            		videoDto.setByteArryString(java.util.Base64.getEncoder().encodeToString(binary));
            		videoDto.setTableName(videoRequestDto.getTableName());
            		videoDto.setCount(loopCount);
                    	
                	ProducerRecord<String, VideoDto> producerRecord = new ProducerRecord<String, VideoDto>(videoRequestDto.getTopic(),videoRequestDto.getTableName(),videoDto);
            		producer.send(producerRecord, new Callback() {
                        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                            // executes every time a record is successfully sent or an exception is thrown
                            if (e == null) {
                                // the record was successfully sent
//                                    log.info("Received new metadata. \n" +
//                                            "Topic:" + recordMetadata.topic() + "\n" +
//                                            "Partition: " + recordMetadata.partition() + "\n" +
//                                            "Offset: " + recordMetadata.offset() + "\n" +
//                                            "Timestamp: " + recordMetadata.timestamp());
                            } else {
                                log.error("Error while producing", e);
                                producer.abortTransaction();
                            }
                            
                        }
                    });
            		loopCount = loopCount + 1;
            	}
            }
        }).connect();
        return socket;
    }
}