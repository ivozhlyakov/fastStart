/*
 * Created by DQCodegen
 */
package ru.diasoft.digitalq.quickstart.publish;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/*
spring:
  cloud:
    stream:
      bindings:
        smsVerificationPublish:
          destination: sms-verification
*/
public interface SmsVerificationPublishChannel {

    @Output(SmsVerificationPublishChannelConstants.SMS_VERIFICATION)
    MessageChannel smsVerification();
    
}