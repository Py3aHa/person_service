package ru.common.medical_clinic.person_service.core.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.common.medical_clinic.person_service.core.model.MedicalCardEntity;
import ru.common.medical_clinic.person_service.dto.MedicalCardDto;

@Component
public class MedicalCardConverter {
    private final ModelMapper modelMapper;

    public MedicalCardConverter() {
        this.modelMapper = new ModelMapper();
    }

    /**
     * Converting an object from MedicalCardDto to MedicalCardEntity.
     * @param medicalCardDto is an MedicalCardDto object that should be converted to MedicalCardEntity
     * @return MedicalCardEntity is an MedicalCardEntity object converted from MedicalCardDto
     */
    public MedicalCardEntity convertToMedicalCardEntity(MedicalCardDto medicalCardDto) {
        return modelMapper.map(medicalCardDto, MedicalCardEntity.class);
    }

    /**
     * Converting an object from MedicalCardEntity to MedicalCardDto.
     * @param medicalCardEntity is an MedicalCardEntity object that should be converted to MedicalCardDto
     * @return medicalCardDto is an MedicalCardDto object converted from MedicalCardEntity
     */
    public MedicalCardDto convertToMedicalCardDto(MedicalCardEntity medicalCardEntity) {
        return modelMapper.map(medicalCardEntity, MedicalCardDto.class);
    }
}
