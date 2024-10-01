package com.si.apirest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.si.apirest.dto.TipoPrendaDTO;
import com.si.apirest.entity.TipoPrenda;
import com.si.apirest.service.TipoPrendaService;

import java.util.List;

@RestController
@RequestMapping("/tipoprenda")
@RequiredArgsConstructor
public class TipoPrendaController {
    
    private final TipoPrendaService tipoPrendaService;

    @PostMapping
    public ResponseEntity<Void> createTipoPrenda(@RequestBody @Valid TipoPrenda tipoPrenda) {
        tipoPrendaService.createTipoPrenda(tipoPrenda);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTipoPrenda(@PathVariable int id, @RequestBody @Valid TipoPrendaDTO tipoPrendaDTO) {
        tipoPrendaService.updateTipoPrenda(tipoPrendaDTO, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoPrenda(@PathVariable int id) {
        tipoPrendaService.deleteTipoPrenda(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPrenda> getTipoPrenda(@PathVariable int id) {
        return ResponseEntity.ok(tipoPrendaService.getTipoPrenda(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<TipoPrendaDTO>> getAllTipoPrenda() {
        return ResponseEntity.ok(tipoPrendaService.getAllTipoPrenda());
    }
}
