package com.project.medicalapp.controller;

import com.project.medicalapp.dto.MedicineDto;
import com.project.medicalapp.dto.request.MedicineRequest;
import com.project.medicalapp.service.MedicineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/medicine")
public class MedicineController {

    private final MedicineService service;

    @PostMapping
    public ResponseEntity<MedicineDto> save(@Valid @RequestBody MedicineRequest request){
        final var dto = service.save(request);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}").build(dto.getId());
        return ResponseEntity.created(location).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicineDto> update(@Valid @RequestBody MedicineRequest request,@PathVariable Long id){
        final var dto = service.update(request,id);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}").build(dto.getId());
        return ResponseEntity.created(location).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicineDto> get(@Valid @PathVariable Long id){
        final var dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<List<MedicineDto>> getAll() {
        final var dtoList = service.findAll();
        return ResponseEntity.ok().body(dtoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
