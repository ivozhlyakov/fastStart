package com.example.testservicews.service;

import com.example.testservicews.entity.Mobile;
import com.example.testservicews.repository.MobileRepo;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileService {

    @Autowired
    private MobileRepo mobileRepo;

    public List<Mobile> getAllMobiles() {
        return mobileRepo.findAll();
    }

    public Mobile getById(Long id) throws NotFound {
        return mobileRepo.findById(id).orElseThrow(NotFound::new);
    }

    public void addMobile(Mobile mobile){
        mobileRepo.save(mobile);
    }

    public void deleteById(Long id) {
        mobileRepo.deleteById(id);
    }

    public Mobile update(Long id, Mobile mobile) throws NotFound {
        Mobile mobileOld = mobileRepo.findById(id).orElseThrow(NotFound::new);
        if (mobile.getModel() != null)
            mobileOld.setModel(mobile.getModel());
        if (mobile.getOperSys() != null)
            mobileOld.setOperSys(mobile.getOperSys());
        mobileOld.setMemory(mobile.getMemory());
        addMobile(mobileOld);
        return getById(id);
    }

}
