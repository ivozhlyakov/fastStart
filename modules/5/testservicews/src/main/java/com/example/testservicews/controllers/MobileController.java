package com.example.testservicews.controllers;

import com.example.testservicews.entity.Mobile;
import com.example.testservicews.service.MobileService;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class MobileController {
    private Integer counter = 1;

    @Autowired
    private MobileService mobileService;

    public MobileController() {
//        mobileService.addMobile("Xiaomi Mi9", "Android", 64);
    }

    @GetMapping("/mobiles")
    public List<Mobile> getAllMobiles() {
        return mobileService.getAllMobiles();
    }

    @GetMapping("/mobiles/{id}")
    public Mobile getById(@PathVariable Long id) throws NotFound {
        return mobileService.getById(id);
    }

    @PostMapping("mobiles")
    public Mobile addMobile(@RequestParam(value = "model") String model,
                                  @RequestParam(value = "operSys") String operSys,
                                  @RequestParam(value = "memory", required = false) Integer memory
                                  ){
        Mobile mobile = new Mobile(model, operSys, memory);
        mobileService.addMobile(mobile);
        return mobile;
    }

    @PutMapping("/mobiles/{id}")
    public Mobile put(@PathVariable Long id, @RequestBody Mobile mobile) throws NotFound {
        return mobileService.update(id, mobile);
    }

    @DeleteMapping("/mobiles/{id}")
    public void deleteById(@PathVariable Long id) throws NotFound {
        mobileService.deleteById(id);
    }


}
