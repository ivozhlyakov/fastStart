package ru.diasoft.digitalq.quickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import ru.diasoft.digitalq.quickstart.publish.SmsVerificationPublishChannel;
import ru.diasoft.digitalq.quickstart.subscribe.SmsVerificationDeliveredSubscribeChannel;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableDiscoveryClient
@EnableCaching
@EnableJpaRepositories({"ru.diasoft.micro", "ru.diasoft.digitalq.quickstart"})
@EntityScan({"ru.diasoft.micro", "ru.diasoft.digitalq.quickstart"})
@ComponentScan({"ru.diasoft.micro", "ru.diasoft.digitalq.quickstart"})
@SpringBootApplication
public class SmsVerificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmsVerificationApplication.class, args);
    }

}
