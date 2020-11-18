package com.example.eventstest.subscriber;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerChannels {
    String DIRECTED = "directed";
    String BROADCASTS = "broadcasts";

    @Input(value = DIRECTED)
    SubscribableChannel directed();

    @Input(value = BROADCASTS)
    SubscribableChannel broadcasts();
}
