package ru.common.medical_clinic.person_service.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.common.medical_clinic.person_service.core.converter.IllnessConverter;
import ru.common.medical_clinic.person_service.core.model.IllnessEntity;
import ru.common.medical_clinic.person_service.core.repository.IllnessRepository;
import ru.common.medical_clinic.person_service.core.service.IllnessService;
import ru.common.medical_clinic.person_service.dto.IllnessDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IllnessServiceImpl implements IllnessService {
    @Autowired
    IllnessRepository illnessRepository;

    @Autowired
    IllnessConverter illnessConverter;

    @Override
    public void save(IllnessDto object) {
        IllnessEntity illnessEntity = illnessConverter.convertContactToEntity(object);
        illnessRepository.insert(illnessEntity);
    }

    @Override
    public IllnessDto findById(Long id) {
        IllnessEntity illnessEntity = illnessRepository.findById(id);
        IllnessDto illnessDto = illnessConverter.convertContactEntityToDto(illnessEntity);
        return illnessDto;
    }

    @Override
    public List<IllnessDto> findAll() {
        List<IllnessEntity> illnessEntities = illnessRepository.findAll();
        List<IllnessDto> illnessDtos = illnessEntities.stream()
                .map(item -> illnessConverter.convertContactEntityToDto(item))
                .collect(Collectors.toList());
        return illnessDtos;
    }

    @Override
    public void update(IllnessDto object) {
        IllnessEntity illnessEntity = illnessConverter.convertContactToEntity(object);
        illnessRepository.update(illnessEntity);
    }

    @Override
    public void delete(Long id) {
        illnessRepository.deleteById(id);
    }
}
