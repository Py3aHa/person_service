package ru.common.medical_clinic.person_service.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.common.medical_clinic.person_service.core.model.Roles;
import ru.common.medical_clinic.person_service.core.repository.RolesRepository;
import ru.common.medical_clinic.person_service.core.service.RolesService;

@Service
public class RolesServiceImpl implements RolesService {
    @Autowired
    RolesRepository rolesRepository;

    @Override
    public void saveRole(Roles role) {
        rolesRepository.insert(role);
    }
}
