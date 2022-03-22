package ru.common.medical_clinic.person_service.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDataEntity {
    private Long id;

    private String lastName;

    private String firstName;

    private LocalDate birthDt;

    private int age;

    private char sex;

    private Long contactId;

    private Long medicalCardId;

    private Long parentId;
}
