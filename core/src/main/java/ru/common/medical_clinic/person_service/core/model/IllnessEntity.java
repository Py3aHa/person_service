package ru.common.medical_clinic.person_service.core.model;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
public class IllnessEntity {
    private Long id;

    private Long medicalCardId;

    private Long typeId;

    private char heaviness;

    private Timestamp appearanceDttm;

    private LocalDate recoveryDt;
}
