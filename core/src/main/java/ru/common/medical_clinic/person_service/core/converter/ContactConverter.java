package ru.common.medical_clinic.person_service.core.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.common.medical_clinic.person_service.core.model.ContactEntity;
import ru.common.medical_clinic.person_service.dto.ContactDto;

@Component
public class ContactConverter {
    private final ModelMapper modelMapper;

    public ContactConverter() {
        this.modelMapper = new ModelMapper();
    }

    /**
     * Converting an object from ContactEntity to ContactDto.
     * @param contactEntity is a ContactEntity object that should be converted to ContactDto
     * @return contactDto is a ContactDto object converted from ContactEntity
     */
    public ContactDto convertContactEntityToDto(ContactEntity contactEntity) {
        return contactEntity == null ? null : modelMapper.map(contactEntity, ContactDto.class);
    }

    /**
     * Converting an object from ContactDto to ContactEntity.
     * @param contactDto is a ContactDto object that should be converted to ContactEntity
     * @return contactEntity is a contactEntity object converted from ContactDto
     */
    public ContactEntity convertContactToEntity(ContactDto contactDto) {
        return contactDto == null ? null : modelMapper.map(contactDto, ContactEntity.class);
    }
}
