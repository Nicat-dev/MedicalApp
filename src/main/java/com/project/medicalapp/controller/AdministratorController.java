package com.project.medicalapp.controller;

import com.project.medicalapp.dto.AdminstrationDto;
import com.project.medicalapp.dto.request.EmployeRegister;
import com.project.medicalapp.service.AdministrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/administrator")
public class AdministratorController {

    private final AdministrationService service;

    @PostMapping
    public ResponseEntity<AdminstrationDto> save(@Valid @RequestBody EmployeRegister register){
        final var dto = service.save(register);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}").build(dto.getId());
        return ResponseEntity.created(location).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminstrationDto> update(@Valid @RequestBody EmployeRegister register,@PathVariable Long id){
        final var dto = service.updateById(register,id);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}").build(dto.getId());
        return ResponseEntity.created(location).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminstrationDto> get(@Valid @PathVariable Long id){
        final var dto = service.getById(id);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<AdminstrationDto>> getList(){
        final var dto = service.getList();
        return ResponseEntity.ok().body(dto);
    }

}
