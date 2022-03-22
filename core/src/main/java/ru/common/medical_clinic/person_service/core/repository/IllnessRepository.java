package ru.common.medical_clinic.person_service.core.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.common.medical_clinic.person_service.core.model.IllnessEntity;

import java.util.List;

@Mapper
public interface IllnessRepository {
    /**
     * Searches for an illness by primary key in the "illness" table of the database.
     *
     * @param id is a unique key of the IllnessEntity object
     * @return object of the IllnessEntity with HttpStatus '302 Found',
     *         otherwise HttpStatus '404 Not Found'
     */
    @Select("select * from illness where id = #{id}")
    IllnessEntity findById(Long id);

    /**
     * Searches for all objects of the "illness" table.
     *
     * @return all objects of the IllnessEntity as a list whit HttpStatus '200 OK'.
     *         If the table is empty, it returns an empty list
     */
    @Select("select * from illness")
    List<IllnessEntity> findAll();

    /**
     * Saves the illness in the "illness" table in the database.
     *
     * @param illnessEntity is object of the IllnessEntity with creation requirements.
     *                      There is no need to pass the 'id' in the request body
     */
    void insert(IllnessEntity illnessEntity);

    /**
     * Modifies illness in the "illness" table.
     *
     * @param illnessEntity is an instance of a class IllnessEntity
     *                      with a primary key that is stored in a table
     */
    void update(IllnessEntity illnessEntity);

    /**
     * Deletes an object from the "illness" table.
     *
     * @param id is a primary key of the IllnessEntity object.
     *           If the object was not found in the table, then deletion does not occur
     */
    void deleteById(@Param("id") Long id);
}
