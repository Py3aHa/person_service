package ru.common.medical_clinic.person_service.core.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.common.medical_clinic.person_service.core.model.AddressEntity;

import java.util.List;

@Mapper
public interface AddressRepository {
    /**
     * Searches for an address by primary key in the "address" table of the database.
     * @param id is a unique key of the AddressEntity object
     * @return AddressEntity object
     */
    @Select("select * from address where id = #{id}")
    AddressEntity findById(Long id);

    /**
     * Searches for all objects of the "address" table.
     * @return all objects of the AddressEntity
     */
    @Select("select * from address")
    List<AddressEntity> findAll();

    /**
     * Saves the address in the "address" table in the database.
     * @param addressEntity is object of the AddressEntity with creation requirements.
     *                      There is no need to pass the 'id' in the request body
     */
    void insert(AddressEntity addressEntity);

    /**
     * Modifies address in the "address" table.
     *
     * @param addressEntity is an instance of a class addressEntity
     *                      with a primary key that is stored in a table
     */
    void update(AddressEntity addressEntity);

    /**
     * Deletes an object from the "address" table.
     *
     * @param id is a primary key of the AddressEntity object.
     *           If the object was not found in the table, then deletion does not occur
     */
    void deleteById(@Param("id") Long id);
}
