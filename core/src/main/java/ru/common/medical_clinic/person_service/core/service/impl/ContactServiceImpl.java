package ru.common.medical_clinic.person_service.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.common.medical_clinic.person_service.core.converter.ContactConverter;
import ru.common.medical_clinic.person_service.core.model.ContactEntity;
import ru.common.medical_clinic.person_service.core.repository.ContactRepository;
import ru.common.medical_clinic.person_service.core.service.ContactService;
import ru.common.medical_clinic.person_service.dto.ContactDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactRepository contactRepository;

    @Autowired
    ContactConverter contactConverter;

    @Override
    public void save(ContactDto object) {
        ContactEntity contactEntity = contactConverter.convertContactToEntity(object);
        contactRepository.insert(contactEntity);
    }

    @Override
    public ContactDto findById(Long id) {
        ContactEntity contactEntity = contactRepository.findById(id);
        ContactDto contactDto = contactConverter.convertContactEntityToDto(contactEntity);
        return contactDto;
    }

    @Override
    public List<ContactDto> findAll() {
        List<ContactEntity> contactEntities = contactRepository.findAll();
        List<ContactDto> contactDtos = contactEntities.stream()
                .map(item -> contactConverter.convertContactEntityToDto(item))
                .collect(Collectors.toList());
        return contactDtos;
    }

    @Override
    public void update(ContactDto object) {
        ContactEntity contactEntity = contactConverter.convertContactToEntity(object);
        contactRepository.update(contactEntity);
    }

    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }
}
