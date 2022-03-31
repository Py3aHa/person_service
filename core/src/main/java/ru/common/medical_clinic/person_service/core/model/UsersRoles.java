package ru.common.medical_clinic.person_service.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersRoles {
    private Long userId;

    private Long roleId;
}
