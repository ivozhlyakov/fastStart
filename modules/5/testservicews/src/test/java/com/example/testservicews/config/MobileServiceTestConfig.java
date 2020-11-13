package com.example.testservicews.config;

import com.example.testservicews.repository.MobileRepo;
import com.example.testservicews.service.MobileService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class MobileServiceTestConfig {

        @Bean
        public MobileService mobileServiceTest(){
            return new MobileService();
        }

}
