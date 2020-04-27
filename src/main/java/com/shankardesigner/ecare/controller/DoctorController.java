package com.shankardesigner.ecare.controller;

import com.shankardesigner.ecare.model.Doctor;
import com.shankardesigner.ecare.serviceImpl.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/ecare/api/doctor")
@CrossOrigin
public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorService;

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctor() {
        return new ResponseEntity<List<Doctor>>(doctorService.getAllInfo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Doctor>> getDoctorById(@PathVariable UUID id) {
        return new ResponseEntity<Optional<Doctor>>(doctorService.getInfoById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveDoctor(@Valid @RequestBody Doctor doctor,BindingResult result) {
        Map<String, String> error = new HashMap<>();

        if(result.hasErrors()) {
            result.getFieldErrors().forEach(item -> error.put(item.getField(), item.getDefaultMessage()));
            System.out.print(error);
            return new ResponseEntity<Map<String, String>>(error, HttpStatus.BAD_REQUEST);
        }
        System.out.println(doctor);
        return new ResponseEntity<Doctor>(doctorService.saveInfo(doctor), HttpStatus.CREATED);
    }
}
