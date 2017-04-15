package com.rinat.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class HelloServiceApplication {

	public static void main(String[] args) {

		System.out.println("...Starting application");

		SpringApplication.run(HelloServiceApplication.class, args);

		System.out.println("...Started application");
	}
}
