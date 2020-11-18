package com.example.eventstest.subscriber.config;

import com.example.eventstest.subscriber.ConsumerChannels;
import com.example.eventstest.subscriber.GreetingMessage;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageListener {

    @StreamListener(ConsumerChannels.DIRECTED)
    public void directed(GreetingMessage message) {
        System.out.println("Directed: " + message);
    }

    @StreamListener(ConsumerChannels.BROADCASTS)
    public void broadcasted(String message) {
        System.out.println("Directed: " + message);
    }
}
