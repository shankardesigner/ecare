package com.shankardesigner.ecare.serviceImpl;

import com.shankardesigner.ecare.model.User;
import com.shankardesigner.ecare.repositiory.UserRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepositiory userRepositiory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepositiory.findByUsername(username);

        //todo user doesnt not exits not working now try to figure it out
        if(user==null) new UsernameNotFoundException("User doesn't exists.");

        //it returns the user details type
        return user;
    }

    //load user by id
    @Transactional
    public User loadUserById(UUID userId) {
        User user = userRepositiory.getByUserId(userId);
        if(user==null) new UsernameNotFoundException("User doesn't exists.");
        return user;
    } 
}
