package ru.common.medical_clinic.person_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IllnessDto {
    @NotBlank
    private Long medicalCardId;

    private Long typeId;

    private char heaviness;

    @NotBlank
    private Timestamp appearanceDttm;

    private LocalDate recoveryDt;
}
