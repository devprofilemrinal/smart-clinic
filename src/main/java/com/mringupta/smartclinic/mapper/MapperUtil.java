package com.mringupta.smartclinic.mapper;

import com.mringupta.smartclinic.dto.PatientDTO;
import com.mringupta.smartclinic.entity.Patient;

public class MapperUtil {
    public static Patient entitymapper(PatientDTO dto) {
        return Patient.builder()
                .id(dto.id())
                .name(dto.name())
                .email(dto.email())
                .age(dto.age())
                .gender(dto.gender())
                .build();
    }

    public static PatientDTO dtoMapper(Patient patient) {
        return new PatientDTO(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getAge(),
                patient.getGender()
        );
    }
}
