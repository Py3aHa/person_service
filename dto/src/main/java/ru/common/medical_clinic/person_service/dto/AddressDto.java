package ru.common.medical_clinic.person_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    @NotBlank
    private Long contactId;

    @NotBlank
    private Long countryId;

    @NotBlank
    private String city;

    private int index;

    @NotBlank
    private String street;

    @NotBlank
    private String building;

    private String flat;
}
