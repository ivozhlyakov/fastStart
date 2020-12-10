/*
 * Created by DQCodegen
 */
package ru.diasoft.digitalq.quickstart.publish;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationMessage;


@MessagingGateway
public interface SmsVerificationPublishGateway {

    @Gateway(requestChannel = SmsVerificationPublishChannelConstants.SMS_VERIFICATION)
    void smsVerification(SmsVerificationMessage msg);

}

