package com.example.websecutirytask.service;

import com.example.websecutirytask.domein.User;
import com.example.websecutirytask.repositiry.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;


    public User getUserByUsername(String username) {
        return userRepo.findByName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return getUserByUsername(s);
    }

}
