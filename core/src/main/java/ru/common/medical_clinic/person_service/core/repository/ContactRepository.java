package ru.common.medical_clinic.person_service.core.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.common.medical_clinic.person_service.core.model.ContactEntity;

import java.util.List;

@Mapper
public interface ContactRepository {
    /**
     * Searches for a contact by primary key in the "contact" table of the database.
     *
     * @param id is a unique key of the ContactEntity object
     * @return object of the ContactEntity
     */
    @Select("select * from contact where id = #{id}")
    ContactEntity findById(Long id);

    /**
     * Searches for all objects of the "contact" table.
     *
     * @return all objects of the ContactEntity
     */
    @Select("select * from contact")
    List<ContactEntity> findAll();

    /**
     * Saves the contact in the "contact" table in the database.
     *
     * @param contactEntity is object of the ContactEntity with creation requirements.
     *                      There is no need to pass the 'id' in the request body
     */
    void insert(ContactEntity contactEntity);

    /**
     * Modifies contact in the "contact" table.
     *
     * @param contactEntity is an instance of a class ContactEntity
     *                      with a primary key that is stored in a table
     */
    void update(ContactEntity contactEntity);

    /**
     * Deletes an object from the "contact" table.
     *
     * @param id is a primary key of the ContactEntity object.
     *           If the object was not found in the table, then deletion does not occur
     */
    void deleteById(@Param("id") Long id);

}
