package ru.common.medical_clinic.person_service.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.common.medical_clinic.person_service.core.converter.PersonDataConverter;
import ru.common.medical_clinic.person_service.core.model.PersonDataEntity;
import ru.common.medical_clinic.person_service.core.repository.PersonDataRepository;
import ru.common.medical_clinic.person_service.core.service.PersonDataService;
import ru.common.medical_clinic.person_service.dto.PersonAddressDto;
import ru.common.medical_clinic.person_service.dto.PersonDataContactDto;
import ru.common.medical_clinic.person_service.dto.PersonDataDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonDataServiceImpl implements PersonDataService {
    @Autowired
    PersonDataRepository personDataRepository;

    @Autowired
    PersonDataConverter personDataConverter;

    @Override
    public void save(PersonDataDto object) {
        PersonDataEntity personDataEntity = personDataConverter.convertPersonDataToEntity(object);
        personDataRepository.insert(personDataEntity);
    }

    @Override
    public PersonDataDto findById(Long id) {
        PersonDataEntity personDataEntity = personDataRepository.findById(id);
        PersonDataDto personDataDto = personDataConverter.convertPersonDataToDto(personDataEntity);
        return personDataDto;
    }

    @Override
    public List<PersonDataDto> findAll() {
        List<PersonDataEntity> personDataEntities = personDataRepository.findAll();
        List<PersonDataDto> personDataDtos = personDataEntities.stream()
                .map(item -> personDataConverter.convertPersonDataToDto(item))
                .collect(Collectors.toList());
        return personDataDtos;
    }

    @Override
    public void update(PersonDataDto object) {
        PersonDataEntity personDataEntity = personDataConverter.convertPersonDataToEntity(object);
        personDataRepository.update(personDataEntity);
    }

    @Override
    public void delete(Long id) {
        personDataRepository.deleteById(id);
    }

    @Override
    public List<PersonDataContactDto> getInnerJoinPersonDataContact() {
        List<PersonDataContactDto> personDataContactDtos = personDataRepository.innerJoinPersonDataAndContact();
        return personDataContactDtos;
    }

    @Override
    public void getPersonDataWithoutRepeatedData() {
        personDataRepository.deleteRepeatedObjects();
    }

    @Override
    public List<PersonDataDto> getHalfPersonData() {
        List<PersonDataEntity> personDataEntities = personDataRepository.getHalfOfPersonData();
        List<PersonDataDto> personDataDtos = personDataEntities.stream()
                .map(item -> personDataConverter.convertPersonDataToDto(item))
                .collect(Collectors.toList());
        return personDataDtos;
    }

    @Override
    public List<PersonDataDto> getPersonDataWithParentWhichHasNotMedicalStatus() {
        List<PersonDataEntity> personDataEntities = personDataRepository.getPersonDataWithParentWhichHasNotMedicalStatus();
        List<PersonDataDto> personDataDtos = personDataEntities.stream()
                .map(item -> personDataConverter.convertPersonDataToDto(item))
                .collect(Collectors.toList());
        return personDataDtos;
    }

    @Override
    public List<PersonAddressDto> getPersonAddressData() {
        List<PersonAddressDto> personAddressDtos = personDataRepository.getPersonAddress();
        return personAddressDtos;
    }

}
