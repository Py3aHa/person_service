package ru.common.medical_clinic.person_service.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.common.medical_clinic.person_service.core.converter.AddressConverter;
import ru.common.medical_clinic.person_service.core.model.AddressEntity;
import ru.common.medical_clinic.person_service.core.repository.AddressRepository;
import ru.common.medical_clinic.person_service.core.service.AddressService;
import ru.common.medical_clinic.person_service.dto.AddressDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    AddressConverter addressConverter;

    @Override
    public void save(AddressDto object) {
        AddressEntity addressEntity = addressConverter.convertContactToEntity(object);
        addressRepository.insert(addressEntity);
    }

    @Override
    public AddressDto findById(Long id) {
        AddressEntity addressEntity = addressRepository.findById(id);
        AddressDto addressDto = addressConverter.convertContactEntityToDto(addressEntity);
        return addressDto;
    }

    @Override
    public List<AddressDto> findAll() {
        List<AddressEntity> addressEntities = addressRepository.findAll();
        List<AddressDto> addressDtos = addressEntities.stream()
                .map(item -> addressConverter.convertContactEntityToDto(item))
                .collect(Collectors.toList());
        return addressDtos;
    }

    @Override
    public void update(AddressDto object) {
        AddressEntity addressEntity = addressConverter.convertContactToEntity(object);
        addressRepository.update(addressEntity);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
