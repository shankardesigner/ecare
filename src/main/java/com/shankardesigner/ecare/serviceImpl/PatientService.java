package com.shankardesigner.ecare.serviceImpl;

import com.shankardesigner.ecare.model.Patient;
import com.shankardesigner.ecare.repositiory.PatientRepositiory;
import com.shankardesigner.ecare.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService implements GenericService<Patient> {

    @Autowired
    private PatientRepositiory patientRepositiory;

    @Override
    public Patient saveInfo(Patient patient) {
        return patientRepositiory.save(patient);
    }

    @Override
    public Patient updateInfo(Patient patient) {
        return patientRepositiory.save(patient);
    }

    @Override
    public boolean deleteInfo(UUID id) {
        patientRepositiory.deleteById(id);
        return true;
    }

    @Override
    public List<Patient> getAllInfo() {
        return patientRepositiory.findAll();
    }

    @Override
    public Optional<Patient> getInfoById(UUID id) {
        return patientRepositiory.findById(id);
    }
}
