package ru.common.medical_clinic.person_service.core.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.common.medical_clinic.person_service.core.model.PersonDataEntity;
import ru.common.medical_clinic.person_service.dto.PersonDataDto;

@Component
public class PersonDataConverter {
    private final ModelMapper modelMapper;

    public PersonDataConverter() {
        this.modelMapper = new ModelMapper();
    }

    /**
     * Converting an object from PersonDataEntity to PersonDataDto.
     * @param personDataEntity is an PersonDataEntity object that should be converted to PersonDataDto
     * @return personDataDto is an PersonDataDto object converted from PersonDataEntity
     */
    public PersonDataDto convertPersonDataToDto(PersonDataEntity personDataEntity) {
        return personDataEntity == null ? null : modelMapper.map(personDataEntity, PersonDataDto.class);
    }

    /**
     * Converting an object from PersonDataDto to PersonDataEntity.
     * @param personDataDto is an PersonDataDto object that should be converted to PersonDataEntity
     * @return personDataEntity is an PersonDataEntity object converted from PersonDataDto
     */
    public PersonDataEntity convertPersonDataToEntity(PersonDataDto personDataDto) {
        return personDataDto == null ? null : modelMapper.map(personDataDto, PersonDataEntity.class);
    }
}
