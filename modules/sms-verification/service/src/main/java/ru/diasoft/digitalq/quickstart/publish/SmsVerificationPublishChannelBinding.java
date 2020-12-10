/*
 * Created by DQCodegen
 */
package ru.diasoft.digitalq.quickstart.publish;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

/*
spring:
  cloud:
    stream:
      bindings:
        smsVerificationPublish:
          destination: sms-verification
*/
@Configuration
@EnableBinding(SmsVerificationPublishChannel.class)
public class SmsVerificationPublishChannelBinding {
}