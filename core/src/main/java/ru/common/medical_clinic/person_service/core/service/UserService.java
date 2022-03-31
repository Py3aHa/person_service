package ru.common.medical_clinic.person_service.core.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.common.medical_clinic.person_service.core.model.PersonDataEntity;
import ru.common.medical_clinic.person_service.dto.PersonDataForAdminDto;

import java.util.List;

public interface UserService extends UserDetailsService {
    /**
     * Performs a search by the email of the object.
     *
     * @param email is unique value of the entity object that is being searched for
     * @return If the object is found, then the object is returned, otherwise null
     */
    PersonDataEntity findByEmail(String email);

    /**
     * Performs a search by the email of the object.
     *
     * @param id is unique value of the entity object that is being searched for
     * @return If the object is found, then the object is returned, otherwise null
     */
    PersonDataEntity findById(Long id);

    /**
     * Modifies the database entity object.
     *
     * @param personData with unique key that is in the database entity
     */
    void update(PersonDataEntity personData);

    /**
     * Allows to delete an entity object that is in the database.
     * Note, it sets 'disabled' parameter of the object as true,
     * by default is false
     *
     * @param id is unique key of the database entity object that is being searched for
     */
    void delete(Long id);

    /**
     * Accepts an object of any entity that is in the database
     * and all the requirements of the entity parameters are met.
     *
     * @param personData
     */
    void savePerson(PersonDataEntity personData);

    /**
     * Searches for all objects without passwords of the database entity.
     *
     * @return entity objects as a list. If there is no object, then an empty list is returned
     */
    List<PersonDataForAdminDto> getAllPersonPrivateData();
}
