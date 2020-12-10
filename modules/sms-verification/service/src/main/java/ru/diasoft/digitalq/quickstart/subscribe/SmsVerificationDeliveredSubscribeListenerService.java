/*
 * Created by DQCodegen
 */
package ru.diasoft.digitalq.quickstart.subscribe;


import ru.diasoft.digitalq.quickstart.model.SmsVerificationDeliveredMessage;


public interface SmsVerificationDeliveredSubscribeListenerService {

    void smsVerificationDelivered(SmsVerificationDeliveredMessage msg);
    
}