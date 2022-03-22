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
import ru.common.medical_clinic.person_service.core.controller.ContactController;
import ru.common.medical_clinic.person_service.core.service.ContactService;
import ru.common.medical_clinic.person_service.dto.ContactDto;

import java.util.List;

@RestController
@RequestMapping(path = "/api/medical/contact")
public class ContactControllerImpl implements ContactController {
    @Autowired
    ContactService contactService;

    @Override
    @PostMapping(path = "/")
    public ResponseEntity<?> saveContact(ContactDto contactDto) {
        contactService.save(contactDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<ContactDto> getContactById(@PathVariable Long id) {
        ContactDto contactDto = contactService.findById(id);
        return contactDto == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(contactDto, HttpStatus.FOUND);
    }

    @Override
    @GetMapping(path = "/")
    public ResponseEntity<List<ContactDto>> getAllContacts() {
        return new ResponseEntity<>(contactService.findAll(), HttpStatus.OK);
    }

    @Override
    @PutMapping(path = "/")
    public void updateContact(ContactDto contactDto) {
        contactService.update(contactDto);
    }

    @Override
    @DeleteMapping(path = "/")
    public void deleteContact(Long id) {
        contactService.delete(id);
    }
}
