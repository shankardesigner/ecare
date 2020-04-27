package com.shankardesigner.ecare.serviceImpl;

import com.shankardesigner.ecare.exceptions.UsernameAlreadyExistsException;
import com.shankardesigner.ecare.model.Roles;
import com.shankardesigner.ecare.model.User;
import com.shankardesigner.ecare.repositiory.RolesRepositiory;
import com.shankardesigner.ecare.repositiory.UserRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import static com.shankardesigner.ecare.config.SecurityConstants.PATIENT_ROLE;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepositiory userRepositiory;

    @Autowired
    private RolesRepositiory rolesRepositiory;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser(User newUser) {
        try {
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            //username has to be unique
            String roleNameFromClient = newUser.getRoles().get(0).getRoleName();
            System.out.println("Retrived roles from the app: " + roleNameFromClient);
            newUser.setUsername(newUser.getUsername());
            newUser.setRoles(Arrays.asList(rolesRepositiory.findByRoleName(roleNameFromClient)));
            //make sure that password and confirm password match
            //we don't persist or show confirm password
            return userRepositiory.save(newUser);

        }catch (Exception e) {
            throw new UsernameAlreadyExistsException("Username " + newUser.getUsername() + " already exits");
        }
    }

    public User getUserByUserName(String username) {
        return userRepositiory.findByUsername(username);
    }
}
