package ru.common.medical_clinic.person_service.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.common.medical_clinic.person_service.core.model.PersonDataEntity;
import ru.common.medical_clinic.person_service.core.model.Roles;
import ru.common.medical_clinic.person_service.core.repository.PersonDataRepository;
import ru.common.medical_clinic.person_service.core.repository.RolesRepository;
import ru.common.medical_clinic.person_service.core.service.UserService;
import ru.common.medical_clinic.person_service.dto.PersonDataForAdminDto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@EnableWebSecurity
public class UserServiceImpl implements UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private PersonDataRepository personDataRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public PersonDataEntity findByEmail(String email) {
        return personDataRepository.findByEmail(email);
    }

    @Override
    public PersonDataEntity findById(Long id) {
        return personDataRepository.findById(id);
    }

    @Override
    public void update(PersonDataEntity personData) {
        personDataRepository.update(personData);
    }

    @Override
    public void delete(Long id) {
        personDataRepository.deleteById(id);
    }

    @Override
    public void savePerson(PersonDataEntity personData) {
        String password = personData.getPassword();
        personData.setPassword(bCryptPasswordEncoder.encode(password));
        personDataRepository.insert(personData);
    }

    @Override
    public List<PersonDataForAdminDto> getAllPersonPrivateData() {
        return personDataRepository.findAllExceptPassword();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        PersonDataEntity personData = findByEmail(email);
        if (personData == null) {
            return null;
        } else {
            Set<Roles> roles = rolesRepository.getAllByPersonId(personData.getId());
            User user = new User(personData.getEmail(), personData.getPassword(), roles);
            List<Roles> cur = user.getAuthorities().stream().map(i -> (Roles) i).collect(Collectors.toList());
            return user;
        }
    }
}
