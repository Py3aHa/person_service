package ru.common.medical_clinic.person_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalCardDto {
    @NotBlank
    private String clientStatus;

    @NotBlank
    private String medStatus;

    private LocalDate registryDt;

    private String comment;
}
