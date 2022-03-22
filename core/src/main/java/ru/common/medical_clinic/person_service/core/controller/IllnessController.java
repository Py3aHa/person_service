package ru.common.medical_clinic.person_service.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.common.medical_clinic.person_service.dto.IllnessDto;

import java.util.List;

public interface IllnessController {
    /**
     * Saves the illness in the "illness" table in the database.
     *
     * @param illnessDto is object of the IllnessDto with creation requirements.
     *                      There is no need to pass the 'id' in the request body
     * @return HttpStatus response '201 CREATED' about creating an object in an entity.
     *         If the requirements were not met, the HttpStatus '500 Internal Server Error' is returned
     */
    @PostMapping(path = "/")
    ResponseEntity<?> saveIllness(@RequestBody IllnessDto illnessDto);

    /**
     * Searches for an illness by primary key in the "illness" table of the database.
     *
     * @param id is a unique key of the IllnessDto object
     * @return object of the IllnessDto with HttpStatus '302 Found',
     *         otherwise HttpStatus '404 Not Found'
     */
    @GetMapping(path = "/{id}")
    ResponseEntity<IllnessDto> getIllnessById(@PathVariable(name = "id") Long id);

    /**
     * Searches for all objects of the "illness" table.
     *
     * @return all objects of the IllnessDto as a list whit HttpStatus '200 OK'.
     *         If the table is empty, it returns an empty list
     */
    @GetMapping(path = "/")
    ResponseEntity<List<IllnessDto>> getAllIllnesses();

    /**
     * Modifies illness in the "illness" table.
     *
     * @param illnessDto is an instance of a class IllnessDto
     *                      with a primary key that is stored in a table
     */
    @PutMapping(path = "/")
    void updateIllness(@RequestBody IllnessDto illnessDto);

    /**
     * Deletes an object from the "illness" table.
     *
     * @param id is a primary key of the IllnessDto object.
     *           If the object was not found in the table, then deletion does not occur
     */
    @DeleteMapping(path = "/{id}")
    void deleteIllness(@PathVariable(name = "id") Long id);
}
