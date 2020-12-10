/*
 * Created by DQCodegen
 */
package ru.diasoft.digitalq.quickstart.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationCheckRequest;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationCheckResponseMock;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationPostRequest;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationPostResponseMock;

@Service
public class SmsVerificationServiceImpl implements SmsVerificationService {

    @Override
    public ResponseEntity<?> dsSmsVerificationGETnonews_v1_0_SmsVerification(
            SmsVerificationCheckRequest smsVerificationCheckRequest) { 
        return ResponseEntity.status(HttpStatus.OK).body(new SmsVerificationCheckResponseMock());  
    } 

    @Override
    public ResponseEntity<?> dsSmsVerificationPOSTnonews_v1_0_SmsVerification(
            SmsVerificationPostRequest smsVerificationPostRequest) { 
        return ResponseEntity.status(HttpStatus.OK).body(new SmsVerificationPostResponseMock());  
    } 

}

