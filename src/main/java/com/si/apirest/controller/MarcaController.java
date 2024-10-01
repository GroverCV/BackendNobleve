package com.si.apirest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.si.apirest.dto.MarcaDTO;
import com.si.apirest.entity.Marca;
import com.si.apirest.service.MarcaService;

import java.util.List;

@RestController
@RequestMapping("/marca")
@RequiredArgsConstructor
public class MarcaController {
    
    private final MarcaService marcaService;

    @PostMapping
    public ResponseEntity<Void> createMarca(@RequestBody @Valid Marca marca) {
        marcaService.createMarca(marca);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMarca(@PathVariable int id, @RequestBody @Valid MarcaDTO marcaDTO) {
        marcaService.updateMarca(marcaDTO, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarca(@PathVariable int id) {
        marcaService.deleteMarca(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> getMarca(@PathVariable int id) {
        return ResponseEntity.ok(marcaService.getMarca(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<MarcaDTO>> getAllMarca() {
        return ResponseEntity.ok(marcaService.getAllMarca());
    }
}
