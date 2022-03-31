package ru.common.medical_clinic.person_service.core.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.common.medical_clinic.person_service.core.controller.AuthenticationController;
import ru.common.medical_clinic.person_service.core.controller.BaseUserDataController;

@RestController
@RequestMapping(path = "/")
public class AuthenticationControllerImpl extends BaseUserDataController implements AuthenticationController {

    @Override
    @RequestMapping(path = "login")
    public void login() {

    }
}
