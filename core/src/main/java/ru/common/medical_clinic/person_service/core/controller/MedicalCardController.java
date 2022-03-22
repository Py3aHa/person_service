package ru.common.medical_clinic.person_service.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.common.medical_clinic.person_service.dto.MedicalCardDto;

import java.util.List;

public interface MedicalCardController {
    /**
     * Saves the medical card in the "medical_card" table in the database.
     * @param medicalCardDto is object of the MedicalCardEntity with creation requirements.
     *                      There is no need to pass the 'id' in the request body
     * @return HttpStatus response '201 CREATED' about creating an object in an entity.
     *         If the requirements were not met, the HttpStatus '500 Internal Server Error' is returned
     */
    @PostMapping(path = "/")
    ResponseEntity<?> saveMedicalCard(@RequestBody MedicalCardDto medicalCardDto);

    /**
     * Searches for a medical card by primary key in the "medical_card" table of the database.
     * @param id is a unique key of the MedicalCardEntity object
     * @return object of the MedicalCardEntity with HttpStatus '302 Found',
     *         otherwise HttpStatus '404 Not Found'
     */
    @GetMapping(path = "/{id}")
    ResponseEntity<MedicalCardDto> getMedicalById(@PathVariable(name = "id") Long id);

    /**
     * Searches for all objects of the "medical_card" table.
     * @return all objects of the MedicalCardEntity as a list whit HttpStatus '200 OK'.
     *         If the table is empty, it returns an empty list
     */
    @GetMapping(path = "/")
    ResponseEntity<List<MedicalCardDto>> getAllMedicalCards();

    /**
     * Modifies medical card data in the "medical_card" table.
     * @param medicalCardDto is an instance of a class MedicalCardDto
     *               with a primary key that is stored in a table
     */
    @PutMapping(path = "/")
    void updateMedicalCard(@RequestBody MedicalCardDto medicalCardDto);

    /**
     * Deletes an object from the "medical_card" table.
     * @param id is a primary key of the MedicalCardEntity object.
     *           If the object was not found in the table, then deletion does not occur
     */
    @DeleteMapping(path = "/{id}")
    void deleteMedicalCard(@PathVariable(name = "id") Long id);
}
