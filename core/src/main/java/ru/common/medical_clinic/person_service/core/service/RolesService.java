package ru.common.medical_clinic.person_service.core.service;

import ru.common.medical_clinic.person_service.core.model.Roles;

public interface RolesService {
    /**
     * Accepts an object of any entity that is in the database
     * and all the requirements of the entity parameters are met.
     *
     * @param role
     */
    void saveRole(Roles role);
}
