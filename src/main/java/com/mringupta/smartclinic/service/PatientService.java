package com.mringupta.smartclinic.service;

import com.mringupta.smartclinic.dto.PatientDTO;
import com.mringupta.smartclinic.entity.Patient;
import com.mringupta.smartclinic.mapper.MapperUtil;
import com.mringupta.smartclinic.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mringupta.smartclinic.mapper.MapperUtil.dtoMapper;
import static com.mringupta.smartclinic.mapper.MapperUtil.entitymapper;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientDTO create(PatientDTO dto) {
        Patient patient = entitymapper(dto);
        return dtoMapper(patientRepository.save(patient));

    }


    public List<PatientDTO> getAll() {
        return patientRepository.findAll()
                .stream()
                .map(MapperUtil::dtoMapper)
                .toList();
    }


    public PatientDTO getById(Long id) {
        return dtoMapper(patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found for the id : " + id)));
    }

    public void delete(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found with ID: " + id);
        }
        patientRepository.deleteById(id);
    }
}