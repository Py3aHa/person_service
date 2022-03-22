package ru.common.medical_clinic.person_service.core.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MedicalCardEntity {
    private Long id;

    private String clientStatus;

    private String medStatus;

    private LocalDate registryDt;

    private String comment;
}
