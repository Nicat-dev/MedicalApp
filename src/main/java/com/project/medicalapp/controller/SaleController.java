package com.project.medicalapp.controller;

import com.project.medicalapp.dto.SalaryDto;
import com.project.medicalapp.dto.SaleDto;
import com.project.medicalapp.dto.request.SalaryRequest;
import com.project.medicalapp.dto.request.SaleRequest;
import com.project.medicalapp.service.SaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sale")
public class SaleController {

    private final SaleService service;

    @PostMapping
    public ResponseEntity<SaleDto> save(@Valid @RequestBody SaleRequest request){
        final var dto = service.save(request);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}").build(dto.getId());
        return ResponseEntity.created(location).body(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<SaleDto> update(@Valid @RequestBody SaleRequest request,@PathVariable Long id){
        final var dto = service.update(request,id);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}").build(dto.getId());
        return ResponseEntity.created(location).body(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity<SaleDto> get(@Valid @PathVariable Long id){
        final var dto = service.find(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<List<SaleDto>> getAll() {
        final var dtoList = service.findAll();
        return ResponseEntity.ok().body(dtoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
