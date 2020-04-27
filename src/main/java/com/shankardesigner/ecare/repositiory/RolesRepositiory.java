package com.shankardesigner.ecare.repositiory;

import com.shankardesigner.ecare.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepositiory extends JpaRepository<Roles, Integer> {
    public Roles findByRoleName(String role);
}
