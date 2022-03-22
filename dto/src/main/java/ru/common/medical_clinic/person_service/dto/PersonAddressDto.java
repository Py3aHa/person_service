package ru.common.medical_clinic.person_service.dto;

import lombok.Data;

@Data
public class PersonAddressDto {
//    private Long id;

    private String lastName;

    private String firstName;

    private String city;

    private String street;

    private String building;

    private String flat;
}
