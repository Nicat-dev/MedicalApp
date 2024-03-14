package com.project.medicalapp.controller;

import com.project.medicalapp.dto.WorkerDto;
import com.project.medicalapp.dto.request.EmployeRegister;
import com.project.medicalapp.service.WorkerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/worker")
public class WorkerController {

    private final WorkerService service;

    @PostMapping
    public ResponseEntity<WorkerDto> save(@Valid @RequestBody EmployeRegister register){
        final var dto = service.save(register);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}").build(dto.getId());
        return ResponseEntity.created(location).body(dto);
    }

    @PutMapping
    public ResponseEntity<WorkerDto> update(@Valid @RequestBody EmployeRegister register){
        final var dto = service.update(register);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}").build(dto.getId());
        return ResponseEntity.created(location).body(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity<WorkerDto> get(@Valid @PathVariable Long id){
        final var dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
