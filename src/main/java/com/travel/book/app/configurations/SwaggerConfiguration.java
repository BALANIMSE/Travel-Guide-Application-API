package com.travel.book.app.configurations;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This is a Swagger Documentation Configuration class
 * 
 * Please see the
 * {@link com.travel.book.app.configurations.SwaggerConfiguration}
 * 
 * @author Bala Nimse
 * 
 */

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Bean
	public Docket swaggerConfigurations() {

		logger.trace("swaggerConfigurations");

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.travel.book")).build().apiInfo(apiDetails());

	}

	private ApiInfo apiDetails() {

		logger.trace("apiDetails");

		return new ApiInfo("Travel Guide", "Travel Guide for Hiking and Other travels ", "1.0", "Free to use",
				new Contact("Balasaheb Nimse", "http://www.travelguide.com", "bala.nimse@travelguide.com"),
				"API License", "http://www.travelguide.com", Collections.emptyList());

	}

}
