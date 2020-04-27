package com.shankardesigner.ecare.controller;

import com.shankardesigner.ecare.model.Address;
import com.shankardesigner.ecare.serviceImpl.AddresServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ecare/api/address")
public class AddressController {

    @Autowired
    private AddresServiceImpl addresService;

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress() {
        return new ResponseEntity<List<Address>>(addresService.getAllInfo(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveAddress(@Valid @RequestBody Address address, BindingResult result) {
        Map<String, String> error = new HashMap<>();

        if(result.hasErrors()) {
            result.getFieldErrors().forEach(item -> error.put(item.getField(), item.getDefaultMessage()));
            System.out.print(error);
            return new ResponseEntity<Map<String, String>>(error, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Address>(addresService.saveInfo(address), HttpStatus.CREATED);
    }
}
