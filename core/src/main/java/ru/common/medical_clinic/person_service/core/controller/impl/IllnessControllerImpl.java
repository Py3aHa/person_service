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
import ru.common.medical_clinic.person_service.core.controller.IllnessController;
import ru.common.medical_clinic.person_service.core.service.IllnessService;
import ru.common.medical_clinic.person_service.dto.IllnessDto;

import java.util.List;

@RestController
@RequestMapping(path = "/api/medical/illness")
public class IllnessControllerImpl implements IllnessController {
    @Autowired
    IllnessService illnessService;

    @Override
    @PostMapping(path = "/")
    public ResponseEntity<?> saveIllness(IllnessDto illnessDto) {
        illnessService.save(illnessDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<IllnessDto> getIllnessById(@PathVariable Long id) {
        IllnessDto illnessDto = illnessService.findById(id);
        return illnessDto == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(illnessDto, HttpStatus.FOUND);
    }

    @Override
    @GetMapping(path = "/")
    public ResponseEntity<List<IllnessDto>> getAllIllnesses() {
        return new ResponseEntity<>(illnessService.findAll(), HttpStatus.OK);
    }

    @Override
    @PutMapping(path = "/")
    public void updateIllness(IllnessDto illnessDto) {
        illnessService.update(illnessDto);
    }

    @Override
    @DeleteMapping(path = "/")
    public void deleteIllness(Long id) {
        illnessService.delete(id);
    }
}
