package ru.diasoft.digitalq.quickstart.repository;

import org.assertj.core.api.AssertProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.diasoft.digitalq.quickstart.Status;
import ru.diasoft.digitalq.quickstart.domain.SmsVerification;

import java.util.UUID;
import static org.assertj.core.api.AssertProvider.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmsVerificationRepositoyTest {

    @Autowired
    private SmsVerificationRepository repository;

    @Test
    public void create() {
        SmsVerification smsVerification = SmsVerification.builder()
                .phonenumber("9201234576")
                .processguid(UUID.randomUUID().toString())
                .secretcode("1234")
                .status(Status.WAITING.name())
                .build();
        SmsVerification result = repository.save(smsVerification);
        Assert.assertNotNull(result.getVerificationid());
        Assert.assertEquals(smsVerification.getPhonenumber(), result.getPhonenumber());
        Assert.assertEquals(smsVerification.getProcessguid(), result.getProcessguid());
        Assert.assertEquals(smsVerification.getSecretcode(), result.getSecretcode());
        Assert.assertEquals(smsVerification.getStatus(), result.getStatus());
    }

    @Test
    public void findBySecretcodeAndProcessguidAndStatus() {
        SmsVerification smsVerification = SmsVerification.builder()
                .phonenumber("9201234576")
                .processguid(UUID.randomUUID().toString())
                .secretcode("1234")
                .status(Status.WAITING.name())
                .build();
        SmsVerification result = repository.save(smsVerification);
        Assert.assertNotNull(result.getVerificationid());

        Assert.assertNotNull(
                repository.findBySecretcodeAndProcessguidAndStatus(
                        smsVerification.getSecretcode()
                        , smsVerification.getProcessguid()
                        ,smsVerification.getStatus()
                )
        );

    }

    @Test
    public void updateStatus() {
        SmsVerification smsVerification = SmsVerification.builder()
                .phonenumber("9201234576")
                .processguid(UUID.randomUUID().toString())
                .secretcode("1234")
                .status(Status.WAITING.name())
                .build();
        SmsVerification result = repository.save(smsVerification);
        Assert.assertNotNull(result.getVerificationid());

        Assert.assertTrue(repository.updateStaus(Status.OK.name(), result.getProcessguid()) > 0);

        Assert.assertNotNull(repository.findBySecretcodeAndProcessguidAndStatus(
                smsVerification.getSecretcode()
                , smsVerification.getProcessguid()
                , Status.OK.name()
        ));

    }
}
