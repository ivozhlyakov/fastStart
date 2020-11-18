package com.example.eventstest;

import com.example.eventstest.subscriber.ConsumerChannels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(ConsumerChannels.class)
public class EventsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsTestApplication.class, args);
	}

}
