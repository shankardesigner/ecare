package com.shankardesigner.ecare.service;

import com.shankardesigner.ecare.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositiory extends JpaRepository<Student, Integer> {
}
