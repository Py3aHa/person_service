package ru.common.medical_clinic.person_service.core.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.common.medical_clinic.person_service.core.controller.PersonDataController;
import ru.common.medical_clinic.person_service.core.service.PersonDataService;
import ru.common.medical_clinic.person_service.dto.PersonAddressDto;
import ru.common.medical_clinic.person_service.dto.PersonDataContactDto;
import ru.common.medical_clinic.person_service.dto.PersonDataDto;

import java.util.List;

@RestController
@RequestMapping(path = "/api/medical/person-data")
public class PersonDataControllerImpl implements PersonDataController {
    @Autowired
    PersonDataService personDataService;

    @Override
    @PostMapping(path = "/")
    public ResponseEntity<?> savePersonData(PersonDataDto personDataDto) {
        personDataService.save(personDataDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PersonDataDto> getPersonDataById(@PathVariable Long id) {
        PersonDataDto personDataDto = personDataService.findById(id);
        return personDataDto == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<PersonDataDto>> getAllPersonData() {

        return new ResponseEntity<>(personDataService.findAll(), HttpStatus.OK);
    }

    @Override
    public void updatePersonData(PersonDataDto personDataDto) {
        personDataService.update(personDataDto);
    }

    @Override
    public void deletePersonData(Long id) {
        personDataService.delete(id);
    }

    @Override
    @GetMapping(path = "/person-contact")
    public ResponseEntity<List<PersonDataContactDto>> getPersonDataAndContact() {
        return new ResponseEntity<>(personDataService.getInnerJoinPersonDataContact(),
                HttpStatus.OK);
    }

    @Override
    @PostMapping(path = "/uniquePersonData")
    public ResponseEntity<List<PersonDataDto>> getUniquePersonData() {
        personDataService.getPersonDataWithoutRepeatedData();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping(path = "/halfOfPersonData")
    public ResponseEntity<List<PersonDataDto>> getHalfPersonData() {
        return new ResponseEntity<>(personDataService.getHalfPersonData(), HttpStatus.OK);
    }

    @Override
    @GetMapping(path = "/child-parent_without_medical_status")
    public ResponseEntity<List<PersonDataDto>> getChildWithParentWhichHasNotMedicalStatus() {
        return new ResponseEntity<>(personDataService.getPersonDataWithParentWhichHasNotMedicalStatus(), HttpStatus.OK);
    }

    @Override
    @GetMapping(path = "/person_address")
    public ResponseEntity<List<PersonAddressDto>> getPersonsAddress() {
        return new ResponseEntity<>(personDataService.getPersonAddressData(), HttpStatus.FOUND);
    }

}
