package ru.common.medical_clinic.person_service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class PersonDataDto {

    @NotBlank
    private String lastName;

    @NotBlank
    private String firstName;

    @NotBlank
    private LocalDate birthDt;

    private int age;

    @NotBlank
    private char sex;

    @NotBlank
    private Long contactId;

    @NotBlank
    private Long medicalCardId;

    private Long parentId;
}
