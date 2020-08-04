package com.demo.companies;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoCompaniesApplication {
	@Value("${timeOut}")
	private int timeOut;
	@Bean
	 public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) 
	{
	    return restTemplateBuilder
	       .setConnectTimeout(Duration.ofSeconds(timeOut))
	       .setReadTimeout(Duration.ofSeconds(timeOut))
	       .build();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoCompaniesApplication.class, args);
	}

}
