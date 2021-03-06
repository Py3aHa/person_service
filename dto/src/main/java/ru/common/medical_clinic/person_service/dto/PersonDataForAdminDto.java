package ru.common.medical_clinic.person_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDataForAdminDto {
    private String lastName;

    private String firstName;

    private String email;

    private boolean disabled;

    private LocalDate birthDt;

    private int age;

    private char sex;

    private Long contactId;

    private Long medicalCardId;

    private Long parentId;
}
