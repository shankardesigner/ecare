package com.shankardesigner.ecare.repositiory;

import com.shankardesigner.ecare.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DoctorRepositiory  extends JpaRepository<Doctor, UUID> {
}
