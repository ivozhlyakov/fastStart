/*
 * Created by DQCodegen
 */
package ru.diasoft.digitalq.quickstart.rest;

import org.springframework.http.ResponseEntity;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationCheckRequest;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationPostRequest;

public interface SmsVerificationService {

    ResponseEntity<?> dsSmsVerificationGETnonews_v1_0_SmsVerification(
            SmsVerificationCheckRequest smsVerificationCheckRequest);

    ResponseEntity<?> dsSmsVerificationPOSTnonews_v1_0_SmsVerification(
            SmsVerificationPostRequest smsVerificationPostRequest);

}
