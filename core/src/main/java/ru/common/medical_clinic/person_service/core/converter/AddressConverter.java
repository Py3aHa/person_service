package ru.common.medical_clinic.person_service.core.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.common.medical_clinic.person_service.core.model.AddressEntity;
import ru.common.medical_clinic.person_service.dto.AddressDto;

@Component
public class AddressConverter {
    private final ModelMapper modelMapper;

    public AddressConverter() {
        this.modelMapper = new ModelMapper();
    }

    /**
     * Converting an object from AddressEntity to AddressDto.
     * @param addressEntity is an AddressEntity object that should be converted to AddressDto
     * @return addressDto is an AddressDto object converted from AddressEntity
     */
    public AddressDto convertContactEntityToDto(AddressEntity addressEntity) {
        return addressEntity == null ? null : modelMapper.map(addressEntity, AddressDto.class);
    }

    /**
     * Converting an object from AddressDto to AddressEntity.
     * @param addressDto is an AddressDto object that should be converted to AddressEntity
     * @return addressEntity is an AddressEntity object converted from AddressDto
     */
    public AddressEntity convertContactToEntity(AddressDto addressDto) {
        return addressDto == null ? null : modelMapper.map(addressDto, AddressEntity.class);
    }
}
