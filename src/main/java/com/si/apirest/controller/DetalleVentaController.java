package com.si.apirest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.si.apirest.dto.DetalleVentaDTO;
import com.si.apirest.entity.DetalleVenta;
import com.si.apirest.service.DetalleVentaService;

import java.util.List;

@RestController
@RequestMapping("/detalle-venta")
@RequiredArgsConstructor
public class DetalleVentaController {
    
    private final DetalleVentaService detalleVentaService;

    @PostMapping
    public ResponseEntity<Void> createDetalleVenta(@RequestBody @Valid DetalleVenta detalleVenta) {
        detalleVentaService.createDetalleVenta(detalleVenta);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDetalleVenta(@PathVariable int id, @RequestBody @Valid DetalleVentaDTO detalleVentaDTO) {
        detalleVentaService.updateDetalleVenta(detalleVentaDTO, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalleVenta(@PathVariable int id) {
        detalleVentaService.deleteDetalleVenta(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> getDetalleVenta(@PathVariable int id) {
        return ResponseEntity.ok(detalleVentaService.getDetalleVenta(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<DetalleVentaDTO>> getAllDetalleVenta() {
        return ResponseEntity.ok(detalleVentaService.getAllDetalleVenta());
    }
}
