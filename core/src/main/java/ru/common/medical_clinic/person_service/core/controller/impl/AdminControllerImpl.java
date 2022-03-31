package ru.common.medical_clinic.person_service.core.controller.impl;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.common.medical_clinic.person_service.core.controller.AdminController;
import ru.common.medical_clinic.person_service.core.controller.BaseUserDataController;
import ru.common.medical_clinic.person_service.dto.PersonDataForAdminDto;

import java.util.List;

@RestController
@RequestMapping(path = "/api/admin")
public class AdminControllerImpl extends BaseUserDataController implements AdminController {

    @Override
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(path = "/users")
    public List<PersonDataForAdminDto> getAllUsers() {
        return userService.getAllPersonPrivateData();
    }
}
