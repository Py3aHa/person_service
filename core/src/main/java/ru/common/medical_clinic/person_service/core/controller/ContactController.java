package ru.common.medical_clinic.person_service.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.common.medical_clinic.person_service.dto.ContactDto;

import java.util.List;

public interface ContactController {
    /**
     * Saves the contact in the "contact" table in the database.
     *
     * @param contactDto is object of the ContactDto with creation requirements.
     *                      There is no need to pass the 'id' in the request body
     * @return HttpStatus response '201 CREATED' about creating an object in an entity.
     *         If the requirements were not met, the HttpStatus '500 Internal Server Error' is returned
     */
    @PostMapping(path = "/")
    ResponseEntity<?> saveContact(@RequestBody ContactDto contactDto);

    /**
     * Searches for a contact by primary key in the "contact" table of the database.
     *
     * @param id is a unique key of the ContactDto object
     * @return object of the ContactDto with HttpStatus '302 Found',
     *         otherwise HttpStatus '404 Not Found'
     */
    @GetMapping(path = "/{id}")
    ResponseEntity<ContactDto> getContactById(@PathVariable(name = "id") Long id);

    /**
     * Searches for all objects of the "contact" table.
     *
     * @return all objects of the ContactDto as a list whit HttpStatus '200 OK'.
     *         If the table is empty, it returns an empty list
     */
    @GetMapping(path = "/")
    ResponseEntity<List<ContactDto>> getAllContacts();

    /**
     * Modifies contact in the "contact" table.
     *
     * @param contactDto is an instance of a class ContactDto
     *                      with a primary key that is stored in a table
     */
    @PutMapping(path = "/")
    void updateContact(@RequestBody ContactDto contactDto);

    /**
     * Deletes an object from the "contact" table.
     *
     * @param id is a primary key of the ContactDto object.
     *           If the object was not found in the table, then deletion does not occur
     */
    @DeleteMapping(path = "/{id}")
    void deleteContact(@PathVariable(name = "id") Long id);
}
