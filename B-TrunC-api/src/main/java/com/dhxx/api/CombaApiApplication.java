package com.dhxx.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableAutoConfiguration
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class CombaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CombaApiApplication.class, args);
	}
}
