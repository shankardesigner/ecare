package com.shankardesigner.ecare.serviceImpl;

import com.shankardesigner.ecare.model.Doctor;
import com.shankardesigner.ecare.repositiory.DoctorRepositiory;
import com.shankardesigner.ecare.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorServiceImpl implements GenericService<Doctor> {

    @Autowired
    private DoctorRepositiory doctorRepositiory;

    @Override
    public Doctor saveInfo(Doctor doctor) {
        return doctorRepositiory.save(doctor);
    }

    @Override
    public Doctor updateInfo(Doctor doctor) {
        return doctorRepositiory.save(doctor);
    }

    @Override
    public boolean deleteInfo(UUID id) {
        doctorRepositiory.deleteById(id);
        return true;
    }

    @Override
    public List<Doctor> getAllInfo() {
        return doctorRepositiory.findAll();
    }

    @Override
    public Optional<Doctor> getInfoById(UUID id) {
        return doctorRepositiory.findById(id);
    }
}
