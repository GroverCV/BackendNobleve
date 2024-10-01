package com.si.apirest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.si.apirest.dto.SucursalDTO;
import com.si.apirest.entity.Sucursal;
import com.si.apirest.service.SucursalService;

import java.util.List;

@RestController
@RequestMapping("/sucursal")
@RequiredArgsConstructor
public class SucursalController {
    
    private final SucursalService sucursalService;

    @PostMapping
    public ResponseEntity<Void> createSucursal(@RequestBody @Valid Sucursal sucursal) {
        sucursalService.createSucursal(sucursal);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSucursal(@PathVariable int id, @RequestBody @Valid SucursalDTO sucursalDTO) {
        sucursalService.updateSucursal(sucursalDTO, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSucursal(@PathVariable int id) {
        sucursalService.deleteSucursal(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> getSucursal(@PathVariable int id) {
        return ResponseEntity.ok(sucursalService.getSucursal(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<SucursalDTO>> getAllSucursal() {
        return ResponseEntity.ok(sucursalService.getAllSucursal());
    }
}
