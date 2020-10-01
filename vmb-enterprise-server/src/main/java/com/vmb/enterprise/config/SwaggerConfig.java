package com.vmb.enterprise.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author pavanvejju
 * 
 * http://localhost:7070/Application/swagger-ui.html
 * http://localhost:7070/swagger-ui.html
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		
		
		ParameterBuilder authorizationTokenParameterBuilder = new ParameterBuilder();
		authorizationTokenParameterBuilder.name("Authorization") // name of header
                         .modelRef(new ModelRef("string"))
                         .parameterType("header") // type - header
                         .defaultValue("Bearer 32c150b8-8fdb-45fd-a550-a714d5e38cfc")
                         .build();
        
	        List<Parameter> parametersList = new ArrayList<>();
	        
	        	parametersList.add(authorizationTokenParameterBuilder.build());
		
		return new Docket(DocumentationType.SWAGGER_2).groupName("invoice-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();//.pathMapping("").globalOperationParameters(parametersList);
	}

	private Predicate<String> postPaths() {
		return or(regex("/api/v1.*"), regex("/com.vmb.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("VMB Enterprise")
				.description("VMB Enterprise API reference for developers")
				.termsOfServiceUrl("http://vmbenterprise.in")
				.contact("pavan.vejju@vmbenterprise.in").license("vmbenterprise License")
				.licenseUrl("pavan.vejju@vmbenterprise.in").version("1.0").build();
	}

}