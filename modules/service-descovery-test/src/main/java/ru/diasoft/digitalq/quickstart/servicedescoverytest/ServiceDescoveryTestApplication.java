package ru.diasoft.digitalq.quickstart.servicedescoverytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServiceDescoveryTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDescoveryTestApplication.class, args);
	}

}
