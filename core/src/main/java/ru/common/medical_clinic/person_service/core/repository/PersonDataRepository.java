package ru.common.medical_clinic.person_service.core.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.common.medical_clinic.person_service.core.model.PersonDataEntity;
import ru.common.medical_clinic.person_service.dto.PersonAddressDto;
import ru.common.medical_clinic.person_service.dto.PersonDataContactDto;

import java.util.List;

@Mapper
public interface PersonDataRepository {
    /**
     * Searches for a person data by primary key in the "person_data" table of the database.
     *
     * @param personId is a unique key of the PersonDataEntity object
     * @return object of the PersonDataEntity
     */
    @Select("select * from person_data where id = #{personId}")
    PersonDataEntity findById(Long personId);

    /**
     * Searches for all objects of the "person_data" table.
     *
     * @return all objects of the PersonDataEntity as a list
     */
    @Select("select * from person_data")
    List<PersonDataEntity> findAll();

    /**
     * Saves the person data in the "person_data" table in the database.
     *
     * @param personDataEntity is object of the PersonDataEntity with creation requirements.
     *                      There is no need to pass the 'id' in the request body
     */
    void insert(PersonDataEntity personDataEntity);

    /**
     * Modifies person data data in the "person_data" table.
     *
     * @param personDataEntity is an instance of a class PersonDataEntity
     *                      with a primary key that is stored in a table
     */
    void update(PersonDataEntity personDataEntity);

    /**
     * Deletes an object from the "person_data" table.
     *
     * @param id is a primary key of the PersonDataEntity object.
     *           If the object was not found in the table, then deletion does not occur
     */
    void deleteById(@Param("id") Long id);

    /**
     * Searches for all objects of the "person_data" and "contact" tables.
     * @return all person data with contact details as list of PersonDataContactDto
     */
    List<PersonDataContactDto> innerJoinPersonDataAndContact();

    /**
     * Searches for all non-repeated objects of the "person_data" table.
     */
    void deleteRepeatedObjects();

    /**
     * Searches for 50% objects of the "person_data" table.
     * @return all person data as list of PersonDataEntity.
     */
    List<PersonDataEntity> getHalfOfPersonData();

    /**
     * Searches for all objects with parents which has medical status of the "person_data" table .
     * @return all person data as list of PersonDataEntity.
     */
    List<PersonDataEntity> getPersonDataWithParentWhichHasNotMedicalStatus();

    /**
     * Searches for all person data with address of the "person_data" and "address" tables.
     * @return all person data as list
     */
    List<PersonAddressDto> getPersonAddress();

}
