package ru.diasoft.digitalq.quickstart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.diasoft.digitalq.quickstart.Status;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationDeliveredMessage;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationMessage;
import ru.diasoft.digitalq.quickstart.repository.SmsVerificationRepository;
import ru.diasoft.digitalq.quickstart.subscribe.SmsVerificationDeliveredSubscribeListenerService;

@RequiredArgsConstructor
@Service
@Primary
public class SmsVerificationListenerService implements SmsVerificationDeliveredSubscribeListenerService{

    private final SmsVerificationRepository repository;

    @Override
    public void smsVerificationDelivered(SmsVerificationDeliveredMessage msg) {
        repository.updateStaus(Status.OK.name(), msg.getCode());
    }

}
