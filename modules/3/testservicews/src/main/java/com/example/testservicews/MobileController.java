package com.example.testservicews;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class MobileController {
    private Integer counter = 1;

    private List<Mobile> mobileList = new ArrayList<Mobile>(){{
        add(new Mobile(counter, "samsung"));
        ++counter;
        add(new Mobile(counter, "nokia"));
        ++counter;
    }};

    @GetMapping("/mobiles")
    public List<Mobile> getAllMobiles() {
        return mobileList;
    }

    @GetMapping("/mobiles/{id}")
    public Mobile getById(@PathVariable Integer id) throws NotFound {
        return mobileList.stream()
                .filter(mobile -> mobile.getId().compareTo(id) == 0)
                .findFirst()
                .orElseThrow(NotFound::new);
    }

    @PostMapping("/add")
    public List<Mobile> addMobile(@RequestBody Map<String, String> map){
        Mobile mobile = new Mobile();
        mobile.setId(counter);
        mobile.setModel(map.get("model"));
        ++counter;
        mobileList.add(mobile);
        return mobileList;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) throws NotFound {
        Mobile mobl = mobileList.stream()
                .filter(mobile -> mobile.getId().compareTo(id) == 0)
                .findFirst()
                .orElseThrow(NotFound::new);

        mobileList.remove(mobl);
    }

    @PostMapping("/edit/{id}")
    public Mobile update(@PathVariable Integer id, @RequestBody Map<String, String> map) throws NotFound {
        Mobile mobile = getById(id);
        mobile.setModel(map.get("model"));
        return mobile;

    }

    @PutMapping("/put/{id}")
    public Mobile put(@PathVariable Integer id, @RequestBody Map<String, String> map) throws NotFound {
        Mobile mobile = getById(id);
        mobile.setYear(Integer.valueOf(map.get("year")));
        return mobile;

    }
}
