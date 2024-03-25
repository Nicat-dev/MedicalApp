package com.project.medicalapp.controller;

import com.project.medicalapp.dto.ProcedureDto;
import com.project.medicalapp.dto.request.ProcedureRequest;
import com.project.medicalapp.service.ProcedureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/procedure")
public class ProcedureController {

    private final ProcedureService service;

    @PostMapping
    public ResponseEntity<ProcedureDto> save(@Valid @RequestBody ProcedureRequest request){
        final var dto = service.save(request);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}").build(dto.getId());
        return ResponseEntity.created(location).body(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProcedureDto> update(@Valid @RequestBody ProcedureRequest request,@PathVariable Long id){
        final var dto = service.update(request,id);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}").build(dto.getId());
        return ResponseEntity.created(location).body(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProcedureDto> get(@Valid @PathVariable Long id){
        final var dto = service.find(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<List<ProcedureDto>> getAll() {
        final var dtoList = service.findAll();
        return ResponseEntity.ok().body(dtoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
