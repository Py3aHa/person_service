package ru.common.medical_clinic.person_service.core.repository;

import org.apache.ibatis.annotations.Mapper;
import ru.common.medical_clinic.person_service.core.model.Roles;

import java.util.Set;

@Mapper
public interface RolesRepository {
    void insert(Roles role);

    Set<Roles> getAllByPersonId(Long id);
}
