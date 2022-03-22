package ru.common.medical_clinic.person_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    @NotBlank
    private String phoneNumber;

    private String email;

    private String profileLink;
}
