package ru.common.medical_clinic.person_service.core.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.common.medical_clinic.person_service.core.controller.AddressController;
import ru.common.medical_clinic.person_service.core.service.AddressService;
import ru.common.medical_clinic.person_service.dto.AddressDto;

import java.util.List;

@RestController
@RequestMapping(path = "/api/medical/address")
public class AddressControllerImpl implements AddressController {
    @Autowired
    AddressService addressService;

    @Override
    @PostMapping(path = "/")
    public ResponseEntity<?> saveAddress(AddressDto addressDto) {
        addressService.save(addressDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable Long id) {
        AddressDto addressDto = addressService.findById(id);
        return addressDto == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(addressDto, HttpStatus.FOUND);
    }

    @Override
    @GetMapping(path = "/")
    public ResponseEntity<List<AddressDto>> getAllAddresses() {
        return new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);
    }

    @Override
    @PutMapping(path = "/")
    public void updateAddress(AddressDto addressDto) {
        addressService.update(addressDto);
    }

    @Override
    @DeleteMapping(path = "/")
    public void deleteAddress(Long id) {
        addressService.delete(id);
    }
}
