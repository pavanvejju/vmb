package com.vmb.enterprise.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import com.vmb.enterprise.config.VmbRouteBuilder;

public class CamelKafkaTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		VmbRouteBuilder routeBuilder	=	new VmbRouteBuilder();
		CamelContext camelContext	=	new DefaultCamelContext();
		camelContext.addRoutes(routeBuilder);
		camelContext.start();
		Thread.sleep(5 * 60 * 1000);
		camelContext.stop();
		
	}

}
