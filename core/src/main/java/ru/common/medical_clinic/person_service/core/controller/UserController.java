package ru.common.medical_clinic.person_service.core.controller;

import ru.common.medical_clinic.person_service.core.model.PersonDataEntity;

public interface UserController {
    /**
     * Performs a search by the email of the object.
     *
     * @param id is unique value of the entity object that is being searched for
     * @return If the object is found, then the object is returned, otherwise null
     */
    PersonDataEntity getPersonData(Long id);

    /**
     * Modifies the database entity object.
     *
     * @param personData with unique key that is in the database entity
     */
    void updateData(PersonDataEntity personData);

    /**
     * Allows to delete an entity object that is in the database.
     * Note, it sets 'disabled' parameter of the object as true,
     * by default is false
     *
     * @param id is unique key of the database entity object that is being searched for
     */
    void deletePersonData(Long id);
}
