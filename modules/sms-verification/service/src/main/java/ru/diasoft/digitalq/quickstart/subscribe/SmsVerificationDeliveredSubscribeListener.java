/*
 * Created by DQCodegen
 */
package ru.diasoft.digitalq.quickstart.subscribe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationDeliveredMessage;


@Configuration
public class SmsVerificationDeliveredSubscribeListener {

    @Autowired
    private SmsVerificationDeliveredSubscribeListenerService listenerService;

    @StreamListener(SmsVerificationDeliveredSubscribeChannelConstants.SMS_VERIFICATION_DELIVERED)
    void smsVerificationDelivered(SmsVerificationDeliveredMessage msg) {
        listenerService.smsVerificationDelivered(msg);
    }
    
}