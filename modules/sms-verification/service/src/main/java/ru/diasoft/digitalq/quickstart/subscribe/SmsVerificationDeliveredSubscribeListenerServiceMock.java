/*
 * Created by DQCodegen
 */
package ru.diasoft.digitalq.quickstart.subscribe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationDeliveredMessage;


@Service
public class SmsVerificationDeliveredSubscribeListenerServiceMock implements SmsVerificationDeliveredSubscribeListenerService {

    Logger logger = LogManager.getLogger(SmsVerificationDeliveredSubscribeListenerServiceMock.class);

    @Override
    public void smsVerificationDelivered(SmsVerificationDeliveredMessage msg) {
        if (logger.isInfoEnabled()) {
            logger.info("SmsVerificationDeliveredSubscribeListenerServiceMock.smsVerificationDelivered: " + msg);
        }
    }
    
}