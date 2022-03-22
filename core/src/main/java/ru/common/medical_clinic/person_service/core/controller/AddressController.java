package ru.common.medical_clinic.person_service.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.common.medical_clinic.person_service.dto.AddressDto;

import java.util.List;

public interface AddressController {
    /**
     * Saves the address in the "address" table in the database.
     *
     * @param addressDto is object of the AddressDto with creation requirements.
     *                      There is no need to pass the 'id' in the request body
     * @return HttpStatus response '201 CREATED' about creating an object in an entity.
     *         If the requirements were not met, the HttpStatus '500 Internal Server Error' is returned
     */
    @PostMapping(path = "/")
    ResponseEntity<?> saveAddress(@RequestBody AddressDto addressDto);

    /**
     * Searches for an address by primary key in the "address" table of the database.
     *
     * @param id is a unique key of the AddressDto object
     * @return object of the AddressDto with HttpStatus '302 Found',
     *         otherwise HttpStatus '404 Not Found'
     */
    @GetMapping(path = "/{id}")
    ResponseEntity<AddressDto> getAddressById(@PathVariable(name = "id") Long id);

    /**
     * Searches for all objects of the "address" table.
     *
     * @return all objects of the AddressDto as a list whit HttpStatus '200 OK'.
     *         If the table is empty, it returns an empty list
     */
    @GetMapping(path = "/")
    ResponseEntity<List<AddressDto>> getAllAddresses();

    /**
     * Modifies address in the "address" table.
     *
     * @param addressDto is an instance of a class AddressDto
     *                      with a primary key that is stored in a table
     */
    @PutMapping(path = "/")
    void updateAddress(@RequestBody AddressDto addressDto);

    /**
     * Deletes an object from the "address" table.
     *
     * @param id is a primary key of the AddressDto object.
     *           If the object was not found in the table, then deletion does not occur
     */
    @DeleteMapping(path = "/{id}")
    void deleteAddress(@PathVariable(name = "id") Long id);

}
