package ru.diasoft.digitalq.quickstart.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import ru.diasoft.digitalq.quickstart.Status;
import ru.diasoft.digitalq.quickstart.domain.SmsVerification;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationCheckRequest;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationCheckResponse;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationPostRequest;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationPostResponse;
import ru.diasoft.digitalq.quickstart.publish.SmsVerificationPublishGateway;
import ru.diasoft.digitalq.quickstart.repository.SmsVerificationRepository;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
class SmsVerificarionPrimaryServiceTest {

    private SmsVerificarionPrimaryService service;

    @Mock
    private SmsVerificationPublishGateway verificationPublishGateway;

    @Mock
    private SmsVerificationRepository repository;


    private final String PHONE_NUMBER = "9201234578";
    private final String VALID_SECRET_CODE = "0001";
    private final String INVALID_SECRET_CODE = "0000";
    private final String GUID = UUID.randomUUID().toString();

    @BeforeEach
    public void init() {
        service = new SmsVerificarionPrimaryService(repository, verificationPublishGateway);

        SmsVerification smsVerification = SmsVerification.builder()
                .phonenumber(PHONE_NUMBER)
                .secretcode(VALID_SECRET_CODE)
                .processguid(GUID)
                .status(Status.OK.name())
                .build();

        Mockito.when(repository.findBySecretcodeAndProcessguidAndStatus(VALID_SECRET_CODE, GUID, Status.OK.name()))
                .thenReturn(Optional.of(smsVerification));
        Mockito.when(repository.findBySecretcodeAndProcessguidAndStatus(INVALID_SECRET_CODE, GUID, Status.OK.name()))
                .thenReturn(Optional.empty());


    }

    @Test
    void dsSmsVerificationGETnonews_v1_0_SmsVerification() {
        SmsVerificationCheckRequest checkRequest = new SmsVerificationCheckRequest();
        checkRequest.setCode(VALID_SECRET_CODE);
        checkRequest.setProcessGUID(GUID);
        ResponseEntity<SmsVerificationCheckResponse> responseEntity = service.dsSmsVerificationGETnonews_v1_0_SmsVerification(checkRequest);

        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        Assert.assertTrue(Objects.requireNonNull(responseEntity.getBody()).getCheckResult());
    }


    @Test
    void dsSmsVerificationGETnonews_v1_0_SmsVerificationInvalidCode() {
        SmsVerificationCheckRequest checkRequest = new SmsVerificationCheckRequest();
        checkRequest.setCode(INVALID_SECRET_CODE);
        checkRequest.setProcessGUID(GUID);
        ResponseEntity<SmsVerificationCheckResponse> responseEntity = service.dsSmsVerificationGETnonews_v1_0_SmsVerification(checkRequest);

        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        Assert.assertFalse(Objects.requireNonNull(responseEntity.getBody()).getCheckResult());
    }

    @Test
    void dsSmsVerificationPOSTnonews_v1_0_SmsVerification() {
        SmsVerificationPostRequest postRequest = new SmsVerificationPostRequest();
        postRequest.setPhoneNumber(PHONE_NUMBER);
        ResponseEntity<SmsVerificationPostResponse> responseEntity = service.dsSmsVerificationPOSTnonews_v1_0_SmsVerification(postRequest);

        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
        Assert.assertFalse(Objects.requireNonNull(responseEntity.getBody()).getProcessGUID().isEmpty());
    }
}