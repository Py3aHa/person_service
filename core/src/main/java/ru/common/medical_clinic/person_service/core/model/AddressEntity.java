package ru.common.medical_clinic.person_service.core.model;

import lombok.Data;

@Data
public class AddressEntity {
    private Long id;

    private Long contactId;

    private Long countryId;

    private String city;

    private int index;

    private String street;

    private String building;

    private String flat;
}
