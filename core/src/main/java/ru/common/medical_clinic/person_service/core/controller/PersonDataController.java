package ru.common.medical_clinic.person_service.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.common.medical_clinic.person_service.dto.PersonAddressDto;
import ru.common.medical_clinic.person_service.dto.PersonDataContactDto;
import ru.common.medical_clinic.person_service.dto.PersonDataDto;

import java.util.List;

public interface PersonDataController {
    /**
     * Saves the person data in the "person_data" table in the database.
     *
     * @param personDataDto is object of the PersonDataDto with creation requirements.
     *                      There is no need to pass the 'id' in the request body
     * @return HttpStatus response '201 CREATED' about creating an object in an entity.
     *         If the requirements were not met, the HttpStatus '500 Internal Server Error' is returned
     */
    @PostMapping(path = "/")
    ResponseEntity<?> savePersonData(@RequestBody PersonDataDto personDataDto);

    /**
     * Searches for a person data by primary key in the "person_data" table of the database.
     *
     * @param id is a unique key of the PersonDataDto object
     * @return object of the PersonDataDto with HttpStatus '302 Found',
     *         otherwise HttpStatus '404 Not Found'
     */
    @GetMapping(path = "/{id}")
    ResponseEntity<PersonDataDto> getPersonDataById(@PathVariable(name = "id") Long id);

    /**
     * Searches for all objects of the "person_data" table.
     *
     * @return all objects of the PersonDataDto as a list whit HttpStatus '200 OK'.
     *         If the table is empty, it returns an empty list
     */
    @GetMapping(path = "/")
    ResponseEntity<List<PersonDataDto>> getAllPersonData();

    /**
     * Modifies person data data in the "person_data" table.
     *
     * @param personDataDto is an instance of a class PersonDataDto
     *                      with a primary key that is stored in a table
     */
    @PutMapping(path = "/")
    void updatePersonData(@RequestBody PersonDataDto personDataDto);

    /**
     * Deletes an object from the "person_data" table.
     *
     * @param id is a primary key of the PersonDataDto object.
     *           If the object was not found in the table, then deletion does not occur
     */
    @DeleteMapping(path = "/{id}")
    void deletePersonData(@PathVariable(name = "id") Long id);

    /**
     * Searches for all objects of the "person_data" and "contact" tables.
     * @return all person data with contact details as list of PersonDataContactDto with HttpStatus '200 OK'.
     */
    @GetMapping(path = "/person-contact")
    ResponseEntity<List<PersonDataContactDto>> getPersonDataAndContact();

    /**
     * Searches for all non-repeated objects of the "person_data" table.
     * @return all unique objects as a list of PersonDataDto with HttpStatus '200 OK'.
     */
    @PostMapping(path = "/uniquePersonData")
    ResponseEntity<List<PersonDataDto>> getUniquePersonData();

    /**
     * Searches for 50% objects of the "person_data" table.
     * @return all person data as list of PersonDataDto with HttpStatus '200 OK'.
     */
    @GetMapping(path = "/halfOfPersonData")
    ResponseEntity<List<PersonDataDto>> getHalfPersonData();

    /**
     * Searches for all objects with parents which has medical status of the "person_data" table .
     * @return all person data as list of PersonDataDto with HttpStatus '200 OK'.
     */
    @GetMapping(path = "/child-parent_without_medical_status")
    ResponseEntity<List<PersonDataDto>> getChildWithParentWhichHasNotMedicalStatus();

    /**
     * Searches for all person data with address of the "person_data" and "address" tables.
     * @return all person data as list of PersonAddressDto with HttpStatus '200 OK'.
     */
    @GetMapping(path = "/person_address")
    ResponseEntity<List<PersonAddressDto>> getPersonsAddress();
}
