package ru.common.medical_clinic.person_service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PersonDataContactDto {
//    private Long id;

    @NotBlank
    private String lastName;

    @NotBlank
    private String firstName;

    @NotBlank
    private String phoneNumber;

    private String email;

    private String profileLink;
}
