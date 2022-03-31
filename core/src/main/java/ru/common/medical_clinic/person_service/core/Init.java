package ru.common.medical_clinic.person_service.core;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import ru.common.medical_clinic.person_service.core.model.PersonDataEntity;
import ru.common.medical_clinic.person_service.core.model.Roles;
import ru.common.medical_clinic.person_service.core.service.impl.RolesServiceImpl;
import ru.common.medical_clinic.person_service.core.service.impl.UserServiceImpl;

//import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

//@Component
public class Init {
    @Autowired
    private RolesServiceImpl rolesService;

    @Autowired
    private UserServiceImpl userService;

    //    @PostConstruct
    public void init() {
        Roles admin = new Roles(null, "ROLE_ADMIN");
        Roles user = new Roles(null, "ROLE_USER");

        rolesService.saveRole(admin);
        rolesService.saveRole(user);

        Set<Roles> allAccess = new HashSet<>();
        Set<Roles> userAccess = new HashSet<>();

        allAccess.add(admin);
        allAccess.add(user);

        userAccess.add(user);

        PersonDataEntity person1 = new PersonDataEntity();
        person1.setFirstName("Ivan");
        person1.setLastName("Ivanov");
        person1.setBirthDt(LocalDate.of(1990, 6, 9));
        person1.setAge(32);
        person1.setSex('m');
        person1.setEmail("ivanov@mail.com");
        person1.setPassword("ivanov");
        person1.setDisabled(false);

        person1.setRoles(allAccess);

        userService.savePerson(person1);

        person1 = new PersonDataEntity();
        person1.setFirstName("Eve");
        person1.setLastName("Ivanova");
        person1.setBirthDt(LocalDate.of(1994, 6, 9));
        person1.setAge(28);
        person1.setSex('f');
        person1.setEmail("ivanova@mail.com");
        person1.setPassword("ivanova");
        person1.setDisabled(false);

        person1.setRoles(userAccess);

        userService.savePerson(person1);

    }
}
