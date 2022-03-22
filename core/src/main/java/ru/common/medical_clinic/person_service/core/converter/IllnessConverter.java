package ru.common.medical_clinic.person_service.core.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.common.medical_clinic.person_service.core.model.IllnessEntity;
import ru.common.medical_clinic.person_service.dto.IllnessDto;

@Component
public class IllnessConverter {
    private final ModelMapper modelMapper;

    public IllnessConverter() {
        this.modelMapper = new ModelMapper();
    }

    /**
     * Converting an object from IllnessEntity to IllnessDto.
     * @param illnessEntity is an IllnessEntity object that should be converted to IllnessDto
     * @return illnessDto is an IllnessDto object converted from IllnessEntity
     */
    public IllnessDto convertContactEntityToDto(IllnessEntity illnessEntity) {
        return illnessEntity == null ? null : modelMapper.map(illnessEntity, IllnessDto.class);
    }

    /**
     * Converting an object from IllnessDto to IllnessEntity.
     * @param illnessDto is an IllnessDto object that should be converted to IllnessEntity
     * @return illnessEntity is an IllnessEntity object converted from IllnessDto
     */
    public IllnessEntity convertContactToEntity(IllnessDto illnessDto) {
        return illnessDto == null ? null : modelMapper.map(illnessDto, IllnessEntity.class);
    }
}
