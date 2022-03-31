package ru.common.medical_clinic.person_service.core.controller.impl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.common.medical_clinic.person_service.core.controller.BaseUserDataController;
import ru.common.medical_clinic.person_service.core.controller.UserController;
import ru.common.medical_clinic.person_service.core.model.PersonDataEntity;

@RestController
@RequestMapping(path = "/users")
public class UserControllerImpl extends BaseUserDataController implements UserController {
    @Override
    @GetMapping(path = "/{id}")
    public PersonDataEntity getPersonData(@PathVariable Long id) {
        return userService.findById(id);
    }

    @Override
    @PutMapping(path = "/")
    public void updateData(@RequestBody PersonDataEntity personData) {
        userService.update(personData);
    }

    @Override
    @DeleteMapping(path = "/{id}")
    public void deletePersonData(@PathVariable Long id) {
        userService.delete(id);
    }
}
