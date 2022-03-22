package ru.common.medical_clinic.person_service.core.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.common.medical_clinic.person_service.core.model.MedicalCardEntity;

import java.util.List;

@Mapper
public interface MedicalCardRepository {
    /**
     * Searches for a medical card by primary key in the "medical_card" table of the database.
     * @param cardId is a unique key of the MedicalCardEntity object
     * @return object of the MedicalCardEntity
     */
    @Select("select * from medical_card where id = #{cardId}")
    MedicalCardEntity findById(Long cardId);

    /**
     * Searches for all objects of the "medical_card" table.
     * @return all objects of the MedicalCardEntity as a list
     */
    @Select("select * from medical_card")
    List<MedicalCardEntity> findAll();

    /**
     * Saves the medical card in the "medical_card" table in the database.
     * @param medicalCardEntity is object of the MedicalCardEntity with creation requirements.
     *                      There is no need to pass the 'id' in the request body
     */
    void insert(MedicalCardEntity medicalCardEntity);

    /**
     * Modifies medical card data in the "medical_card" table.
     * @param medicalCardEntity is an instance of a class MedicalCardEntity
     *               with a primary key that is stored in a table
     */
    void update(MedicalCardEntity medicalCardEntity);

    /**
     * Deletes an object from the "medical_card" table.
     * @param id is a primary key of the MedicalCardEntity object.
     *           If the object was not found in the table, then deletion does not occur
     */
    void deleteById(@Param("id") Long id);
}
