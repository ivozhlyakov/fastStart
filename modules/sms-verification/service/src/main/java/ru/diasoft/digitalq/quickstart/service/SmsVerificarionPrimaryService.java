package ru.diasoft.digitalq.quickstart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.diasoft.digitalq.quickstart.Status;
import ru.diasoft.digitalq.quickstart.domain.SmsVerification;
import ru.diasoft.digitalq.quickstart.model.*;
import ru.diasoft.digitalq.quickstart.publish.SmsVerificationPublishGateway;
import ru.diasoft.digitalq.quickstart.repository.SmsVerificationRepository;
import ru.diasoft.digitalq.quickstart.rest.SmsVerificationService;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Primary
public class SmsVerificarionPrimaryService implements SmsVerificationService {

    private final SmsVerificationRepository repository;
    private final SmsVerificationPublishGateway publishGateway;

    @Override
    public ResponseEntity<SmsVerificationCheckResponse> dsSmsVerificationGETnonews_v1_0_SmsVerification(SmsVerificationCheckRequest smsVerificationCheckRequest) {
        Optional<SmsVerification> verification = repository.findBySecretcodeAndProcessguidAndStatus(
                smsVerificationCheckRequest.getCode()
                ,smsVerificationCheckRequest.getProcessGUID()
                ,Status.OK.name()
        );
        return ResponseEntity.status(HttpStatus.OK).body(new SmsVerificationCheckResponse(verification.isPresent()));
    }

    @Override
    public ResponseEntity<SmsVerificationPostResponse> dsSmsVerificationPOSTnonews_v1_0_SmsVerification(SmsVerificationPostRequest smsVerificationPostRequest) {
        String guid = UUID.randomUUID().toString();
        String secredCode = String.format("%04d", new Random().nextInt(100000));
        SmsVerification smsVerification = SmsVerification.builder()
                .phonenumber(smsVerificationPostRequest.getPhoneNumber())
                .processguid(guid)
                .secretcode(secredCode)
                .status(Status.WAITING.name()).build();

        repository.save(smsVerification);

        publishGateway.smsVerification(SmsVerificationMessage.builder().guid(smsVerification.getProcessguid()).build());

        return ResponseEntity.status(HttpStatus.CREATED).body(new SmsVerificationPostResponse(guid));
    }
}
