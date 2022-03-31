package ru.common.medical_clinic.person_service.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import ru.common.medical_clinic.person_service.dto.PersonDataForAdminDto;

import java.util.List;

public interface AdminController {
    /**
     * Searches for all objects without passwords of the database entity.
     *
     * @return entity objects as a list. If there is no object, then an empty list is returned
     */
    @GetMapping("/users")
    List<PersonDataForAdminDto> getAllUsers();
}
