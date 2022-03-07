package ru.common.medical_clinic.person_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "deviation_by_indicators")
public class DeviationByIndicators {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviation;

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "information_from_device_id")
    private Long informationFromDeviceId;
}
