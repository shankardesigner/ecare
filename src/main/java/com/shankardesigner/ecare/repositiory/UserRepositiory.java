package com.shankardesigner.ecare.repositiory;

import com.shankardesigner.ecare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepositiory extends JpaRepository<User, UUID> {
    User findByUsername(String username);
    User getByUserId(UUID userId);
}
