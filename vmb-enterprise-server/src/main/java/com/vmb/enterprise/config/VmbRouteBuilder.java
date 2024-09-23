package com.vmb.enterprise.config;

import org.apache.camel.builder.RouteBuilder;

public class VmbRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		String topicName = "topic=sample-topic";
		String kafkaServer = "kafka:localhost:9092";
		String zooKeeperHost = "zookeeperHost=localhost&zookeeperPort=2181";
		String serializerClass = "serializerClass=com.vmb.enterprise.utils.CustomSerializer";

		String toKafka = new StringBuilder().append(kafkaServer).append("?").append(topicName).append("&")
				.append(zooKeeperHost).append("&").append(serializerClass).toString();

		
		from("file:/tmp/inbox?noop=true").split().tokenize("\n").to(toKafka);
		
		/*
		@Override
	        from("direct:kafka-producer")
	            .setHeader(KafkaConstants.KEY, constant("my-key"))
	            .to("kafka:my-topic");
	    }*/
		
		
	}

}
