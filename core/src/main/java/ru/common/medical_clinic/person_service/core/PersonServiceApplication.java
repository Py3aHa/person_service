package ru.common.medical_clinic.person_service.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("ru.common.medical_clinic.*")
public class PersonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonServiceApplication.class, args);
    }

}
