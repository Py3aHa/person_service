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
import ru.common.medical_clinic.person_service.core.controller.MedicalCardController;
import ru.common.medical_clinic.person_service.core.service.MedicalCardService;
import ru.common.medical_clinic.person_service.dto.MedicalCardDto;

import java.util.List;

@RestController
@RequestMapping(path = "/api/medical/medical-card")
public class MedicalCardControllerImpl implements MedicalCardController {
    @Autowired
    MedicalCardService medicalCardService;

    @Override
    @PostMapping(path = "/")
    public ResponseEntity<?> saveMedicalCard(MedicalCardDto medicalCardDto) {
        medicalCardService.save(medicalCardDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<MedicalCardDto> getMedicalById(@PathVariable Long id) {
        MedicalCardDto medicalCardDto = medicalCardService.findById(id);
        return medicalCardDto == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(medicalCardDto, HttpStatus.FOUND);
    }

    @Override
    @GetMapping(path = "/")
    public ResponseEntity<List<MedicalCardDto>> getAllMedicalCards() {
        return new ResponseEntity<>(medicalCardService.findAll(), HttpStatus.OK);
    }

    @Override
    @PutMapping(path = "/")
    public void updateMedicalCard(MedicalCardDto medicalCardDto) {
        medicalCardService.update(medicalCardDto);
    }

    @Override
    @DeleteMapping(path = "/")
    public void deleteMedicalCard(Long id) {
        medicalCardService.delete(id);
    }
}
