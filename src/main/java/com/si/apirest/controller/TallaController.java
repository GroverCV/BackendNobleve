package com.si.apirest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.si.apirest.dto.TallaDTO;
import com.si.apirest.entity.Talla;
import com.si.apirest.service.TallaService;

import java.util.List;

@RestController
@RequestMapping("/talla")
@RequiredArgsConstructor
public class TallaController {
    
    private final TallaService tallaService;

    @PostMapping
    public ResponseEntity<Void> createTalla(@RequestBody @Valid Talla talla) {
        tallaService.createTalla(talla);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTalla(@PathVariable int id, @RequestBody @Valid TallaDTO tallaDTO) {
        tallaService.updateTalla(tallaDTO, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTalla(@PathVariable int id) {
        tallaService.deleteTalla(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Talla> getTalla(@PathVariable int id) {
        return ResponseEntity.ok(tallaService.getTalla(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<TallaDTO>> getAllTalla() {
        return ResponseEntity.ok(tallaService.getAllTalla());
    }
}
