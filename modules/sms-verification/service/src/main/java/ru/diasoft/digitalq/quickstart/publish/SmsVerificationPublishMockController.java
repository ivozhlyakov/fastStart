/*
 * Created by DQCodegen
 */
package ru.diasoft.digitalq.quickstart.publish;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationMessage;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationMessageMock;


@RestController("mock-ctlr-smsVerification")
@Api(tags = {"mock-ctlr-smsverification"})
public class SmsVerificationPublishMockController  {

    @Autowired
    private SmsVerificationPublishGateway gateway;

    @GetMapping (value = "/mock/smsVerification")
    @ApiOperation(value = "smsVerification", tags = {"mock-ctlr-smsverification"})
    public ResponseEntity<SmsVerificationMessage> smsVerification() {
         SmsVerificationMessage mock = new SmsVerificationMessageMock();
         gateway.smsVerification(mock);
         return ResponseEntity.status(HttpStatus.OK).body(mock);
     }

}

