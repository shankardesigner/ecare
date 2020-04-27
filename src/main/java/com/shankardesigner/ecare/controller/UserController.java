package com.shankardesigner.ecare.controller;

import com.shankardesigner.ecare.config.JwtTokenProvider;
import com.shankardesigner.ecare.model.User;
import com.shankardesigner.ecare.payload.JWTLoginSuccessResponse;
import com.shankardesigner.ecare.payload.LoginRequest;
import com.shankardesigner.ecare.service.MapValidationErrorService;
import com.shankardesigner.ecare.serviceImpl.UserServiceImpl;
import com.shankardesigner.ecare.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Arrays;
import java.util.logging.Logger;

import static com.shankardesigner.ecare.config.SecurityConstants.TOKEN_PREFIX;

@RestController
@RequestMapping("/ecare/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);

        if(errorMap != null) return errorMap;

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX + jwtTokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTLoginSuccessResponse(true,jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result) {
        //validate the passwords

        userValidator.validate(user,result);
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;

        User newUser = userService.saveUser(user);
        newUser.setConfirmPassword(newUser.getPassword());

        System.out.println(newUser);

        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public User getUserByUserName(@PathVariable String username) {
        return userService.getUserByUserName(username);
    }
}
