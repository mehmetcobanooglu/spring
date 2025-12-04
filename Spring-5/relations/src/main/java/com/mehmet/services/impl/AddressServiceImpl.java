package com.mehmet.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.mehmet.dto.DtoAddress;
import com.mehmet.dto.DtoCustomer;
import com.mehmet.entities.Address;
import com.mehmet.repository.AddressRepository;
import com.mehmet.services.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public DtoAddress findAddressById(Long id) {

        DtoAddress dtoAddress = new DtoAddress();

        Optional<Address> optional = addressRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        Address address = optional.get();
        BeanUtils.copyProperties(address, dtoAddress);

        DtoCustomer dtoCustomer = new DtoCustomer();

        dtoCustomer.setId(address.getCustomer().getId());
        dtoCustomer.setName(address.getCustomer().getName());

        // dtoCustomer.setAddress(dtoAddress);

        dtoAddress.setCustomer(dtoCustomer);

        return dtoAddress;
    }

}
