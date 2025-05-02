package com.mringupta.smartclinic.controller;


import com.mringupta.smartclinic.dto.PatientDTO;
import com.mringupta.smartclinic.response.ResponseObject;
import com.mringupta.smartclinic.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<ResponseObject<PatientDTO>> create(@RequestBody @Valid PatientDTO dto) {
        PatientDTO savedPatient = patientService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseObject.success("patient created successfully", HttpStatus.OK.value(), savedPatient));
    }

    @GetMapping
    public ResponseEntity<ResponseObject<List<PatientDTO>>> getAll() {
        List<PatientDTO> all = patientService.getAll();
        return ResponseEntity.ok(ResponseObject.success("List of all patients", all, HttpStatus.OK.value()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject<PatientDTO>> getById(@PathVariable Long id) {
        PatientDTO found = patientService.getById(id);
        return ResponseEntity.ok(ResponseObject.success("Patient found", HttpStatus.OK.value(), found));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject<Void>> delete(@PathVariable Long id) {
        patientService.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Patient deleted", null, HttpStatus.OK.value()));
    }
}

