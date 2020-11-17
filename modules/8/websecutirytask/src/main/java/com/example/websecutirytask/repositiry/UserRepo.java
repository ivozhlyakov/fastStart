package com.example.websecutirytask.repositiry;

import com.example.websecutirytask.domein.Role;
import com.example.websecutirytask.domein.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserRepo  {

    private List<User> userList = Arrays.asList(
            new User("user", new BCryptPasswordEncoder().encode("password"), Collections.singletonList(Role.USER)),
            new User("user1",  new BCryptPasswordEncoder().encode("password1"), Collections.singletonList(Role.USER)),
            new User("user2",  new BCryptPasswordEncoder().encode("password2"), Collections.singletonList(Role.USER))
    );

    public User findByName(String name) {
        User userOut = null;
        for (User user : userList) {
            if (name.equals(user.getUsername())) {
                userOut = user;
                break;
            }
        }
        return userOut;
    }

}
