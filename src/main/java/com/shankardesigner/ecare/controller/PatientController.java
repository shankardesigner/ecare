package com.shankardesigner.ecare.controller;

import com.shankardesigner.ecare.model.Patient;
import com.shankardesigner.ecare.serviceImpl.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/ecare/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatient() {
        return new ResponseEntity<List<Patient>>(patientService.getAllInfo(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Patient>> getPatientById(@PathVariable UUID id) {
        return new ResponseEntity<Optional<Patient>>(patientService.getInfoById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> savePatient(@Valid @RequestBody Patient patient, BindingResult result) {
        Map<String, String> error = new HashMap<>();

        if(result.hasErrors()) {
            result.getFieldErrors().forEach(item -> error.put(item.getField(), item.getDefaultMessage()));
            return new ResponseEntity<Map<String,String>>(error, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Patient>(patientService.saveInfo(patient), HttpStatus.CREATED);
    }
}
