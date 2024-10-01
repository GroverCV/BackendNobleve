package com.si.apirest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.si.apirest.dto.InventarioDTO;
import com.si.apirest.entity.Inventario;
import com.si.apirest.service.InventarioService;

import java.util.List;

@RestController
@RequestMapping("/inventario")
@RequiredArgsConstructor
public class InventarioController {
    
    private final InventarioService inventarioService;

    @PostMapping
    public ResponseEntity<Void> createInventario(@RequestBody @Valid Inventario inventario) {
        inventarioService.createInventario(inventario);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateInventario(@PathVariable int id, @RequestBody @Valid InventarioDTO inventarioDTO) {
        inventarioService.updateInventario(inventarioDTO, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventario(@PathVariable int id) {
        inventarioService.deleteInventario(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> getInventario(@PathVariable int id) {
        return ResponseEntity.ok(inventarioService.getInventario(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<InventarioDTO>> getAllInventario() {
        return ResponseEntity.ok(inventarioService.getAllInventario());
    }
}
