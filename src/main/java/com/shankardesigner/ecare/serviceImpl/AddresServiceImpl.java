package com.shankardesigner.ecare.serviceImpl;

import com.shankardesigner.ecare.model.Address;
import com.shankardesigner.ecare.repositiory.AddressRepositiory;
import com.shankardesigner.ecare.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddresServiceImpl implements GenericService<Address> {

    @Autowired
    private AddressRepositiory addressRepositiory;

    @Override
    public Address saveInfo(Address address) {
        return addressRepositiory.save(address);
    }

    @Override
    public Address updateInfo(Address address) {
        return addressRepositiory.save(address);
    }

    @Override
    public boolean deleteInfo(UUID id) {
        addressRepositiory.deleteById(id);
        return true;
    }

    @Override
    public List<Address> getAllInfo() {
        return addressRepositiory.findAll();
    }

    @Override
    public Optional<Address> getInfoById(UUID id) {
        return addressRepositiory.findById(id);
    }
}
