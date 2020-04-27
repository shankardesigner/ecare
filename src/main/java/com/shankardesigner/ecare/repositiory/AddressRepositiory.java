package com.shankardesigner.ecare.repositiory;

import com.shankardesigner.ecare.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepositiory extends JpaRepository<Address, UUID> {
}
