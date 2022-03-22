package ru.common.medical_clinic.person_service.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.common.medical_clinic.person_service.core.converter.MedicalCardConverter;
import ru.common.medical_clinic.person_service.core.model.MedicalCardEntity;
import ru.common.medical_clinic.person_service.core.repository.MedicalCardRepository;
import ru.common.medical_clinic.person_service.core.service.MedicalCardService;
import ru.common.medical_clinic.person_service.dto.MedicalCardDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalCardServiceImpl implements MedicalCardService {
    @Autowired
    MedicalCardRepository medicalCardRepository;

    @Autowired
    MedicalCardConverter medicalCardConverter;

    @Override
    public void save(MedicalCardDto object) {
        MedicalCardEntity medicalCardEntity = medicalCardConverter.convertToMedicalCardEntity(object);
        medicalCardRepository.insert(medicalCardEntity);
    }

    @Override
    public MedicalCardDto findById(Long id) {
        MedicalCardEntity medicalCardEntity = medicalCardRepository.findById(id);
        return medicalCardConverter.convertToMedicalCardDto(medicalCardEntity);
    }

    @Override
    public List<MedicalCardDto> findAll() {
        List<MedicalCardEntity> medicalCardEntities = medicalCardRepository.findAll();
        List<MedicalCardDto> medicalCardDtos = medicalCardEntities.stream()
                .map(item -> medicalCardConverter.convertToMedicalCardDto(item))
                .collect(Collectors.toList());
        return medicalCardDtos;
    }

    @Override
    public void update(MedicalCardDto object) {
        MedicalCardEntity medicalCardEntity = medicalCardConverter.convertToMedicalCardEntity(object);
        medicalCardRepository.update(medicalCardEntity);
    }

    @Override
    public void delete(Long id) {
        medicalCardRepository.deleteById(id);
    }
}
