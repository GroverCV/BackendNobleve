package com.si.apirest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.si.apirest.dto.DescuentoDTO;
import com.si.apirest.entity.Descuento;
import com.si.apirest.service.DescuentoService;

import java.util.List;

@RestController
@RequestMapping("/descuento")
@RequiredArgsConstructor
public class DescuentoController {
    
    private final DescuentoService descuentoService;

    @PostMapping
    public ResponseEntity<Void> createDescuento(@RequestBody @Valid Descuento descuento) {
        descuentoService.createDescuento(descuento);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDescuento(@PathVariable int id, @RequestBody @Valid DescuentoDTO descuentoDTO) {
        descuentoService.updateDescuento(descuentoDTO, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDescuento(@PathVariable int id) {
        descuentoService.deleteDescuento(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Descuento> getDescuento(@PathVariable int id) {
        return ResponseEntity.ok(descuentoService.getDescuento(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<DescuentoDTO>> getAllDescuento() {
        return ResponseEntity.ok(descuentoService.getAllDescuento());
    }
}
