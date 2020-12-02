package ru.diasoft.digitalq.quickstart.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import ru.diasoft.digitalq.quickstart.SmsVerificationApplication;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SmsVerificationApplication.class);
    }

}
