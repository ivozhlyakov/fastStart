/*
 * Created by DQCodegen
 */
package ru.diasoft.digitalq.quickstart.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationCheckRequest;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationCheckResponse;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationPostRequest;
import ru.diasoft.digitalq.quickstart.model.SmsVerificationPostResponse;
import ru.diasoft.micro.mdp.lib.utils.exception.APIException;
import ru.diasoft.micro.mdp.lib.utils.exception.ExceptionUtils;

@RestController("ru.diasoft.digitalq.quickstart.rest.SmsVerificationController")
@Api(tags = {"SmsVerification"})
public class SmsVerificationController {

    private final SmsVerificationService smsVerificationService;
    
    @Autowired    
    public SmsVerificationController(SmsVerificationService smsVerificationService) {
        this.smsVerificationService = smsVerificationService;
    }

    @GetMapping("/v1/sms-verification")
    @ApiOperation(value = "Метод проверяет, что введенный код соответствует отправленному.", response = SmsVerificationCheckResponse.class, tags = {"SmsVerification"})
    public ResponseEntity<?> dsSmsVerificationGETnonews_v1_0_SmsVerification(
                @RequestParam(name = "ProcessGUID") String processGUID,
                @RequestParam(name = "Code") String code
                ) {
        try {

            return smsVerificationService.dsSmsVerificationGETnonews_v1_0_SmsVerification(
                    SmsVerificationCheckRequest.builder()
                    .processGUID(processGUID)
                    .code(code)
                    .build()
            );
        } catch (APIException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ExceptionUtils.buildErrorData(e));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ExceptionUtils.buildErrorData(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }

    @PostMapping("/sms-verification")
    @ApiOperation(value = "Отправка проверочного кода на телефон клиента.", response = SmsVerificationPostResponse.class, tags = {"SmsVerification"})
    public ResponseEntity<?> dsSmsVerificationPOSTnonews_v1_0_SmsVerification(
                @RequestBody
                @ApiParam(name = "SmsVerificationPostRequest", value = "", required = false)
                SmsVerificationPostRequest smsVerificationPostRequest) {
        try {                                                                                 
            return smsVerificationService.dsSmsVerificationPOSTnonews_v1_0_SmsVerification(
                smsVerificationPostRequest);         
        } catch (APIException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ExceptionUtils.buildErrorData(e));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ExceptionUtils.buildErrorData(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }

}
