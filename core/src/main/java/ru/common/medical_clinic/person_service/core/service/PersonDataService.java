package ru.common.medical_clinic.person_service.core.service;

import ru.common.medical_clinic.person_service.dto.PersonAddressDto;
import ru.common.medical_clinic.person_service.dto.PersonDataContactDto;
import ru.common.medical_clinic.person_service.dto.PersonDataDto;

import java.util.List;

public interface PersonDataService extends BasicCRUDService<PersonDataDto> {
    /**
     * Searches for all objects of the "person_data" and "contact" tables.
     * @return all person data with contact details as list of PersonDataContactDto
     */
    List<PersonDataContactDto> getInnerJoinPersonDataContact();

    /**
     * Searches for all non-repeated objects of the "person_data" table.
     */
    void getPersonDataWithoutRepeatedData();

    /**
     * Searches for 50% objects of the "person_data" table.
     * @return all person data as list of PersonDataEntity.
     */
    List<PersonDataDto> getHalfPersonData();

    /**
     * Searches for all objects with parents which has medical status of the "person_data" table .
     * @return all person data as list of PersonDataEntity.
     */
    List<PersonDataDto> getPersonDataWithParentWhichHasNotMedicalStatus();

    /**
     * Searches for all person data with address of the "person_data" and "address" tables.
     * @return all person data as list
     */
    List<PersonAddressDto> getPersonAddressData();
}
