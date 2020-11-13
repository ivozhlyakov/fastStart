package com.example.testservicews.service;

import com.example.testservicews.entity.Mobile;
import com.example.testservicews.service.MobileService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class MobileServiceTest {

    @TestConfiguration
    static class MobileServiceTestConfig{
        @Bean
        public MobileService mobileServiceTest(){
            return new MobileService();
        }
    }

    @Autowired
    public MobileService mobileService;

    @Test
    public void serviceMethodsTests() throws NotFound {
        Mobile mobile = new Mobile("iphone", "ios", 64);
        mobileService.addMobile(mobile);
        Long id = mobile.getId();
        Assert.assertNotNull(id);

        getAll();

        getById(id);

        update(mobile);

        deleteById(id);

    }

    public void getAll() {
        Assert.assertTrue(mobileService.getAllMobiles().size()>0);
    }

    public void getById(Long id) throws NotFound {
        Assert.assertNotNull(mobileService.getById(id));
    }

    public void update(Mobile mobile) throws NotFound {
        mobile.setMemory(128);
        mobileService.update(mobile.getId(), mobile);
        Assert.assertEquals(128, (int) mobileService.getById(mobile.getId()).getMemory());
    }

    public void deleteById(Long id) {
        mobileService.deleteById(id);
    }
}
