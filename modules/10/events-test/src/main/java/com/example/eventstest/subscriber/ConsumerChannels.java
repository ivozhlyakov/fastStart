package com.example.eventstest.subscriber;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerChannels {
    String LISENER = "lisener";

    @Input(value = LISENER)
    SubscribableChannel lisener();
}
