package com.si.apirest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.si.apirest.dto.NotaVentaDTO;
import com.si.apirest.entity.NotaVenta;
import com.si.apirest.service.NotaVentaService;

import java.util.List;

@RestController
@RequestMapping("/nota-venta")
@RequiredArgsConstructor
public class NotaVentaController {
    
    private final NotaVentaService notaVentaService;

    @PostMapping
    public ResponseEntity<Void> createNotaVenta(@RequestBody @Valid NotaVenta notaVenta) {
        notaVentaService.createNotaVenta(notaVenta);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateNotaVenta(@PathVariable int id, @RequestBody @Valid NotaVentaDTO notaVentaDTO) {
        notaVentaService.updateNotaVenta(notaVentaDTO, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotaVenta(@PathVariable int id) {
        notaVentaService.deleteNotaVenta(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaVenta> getNotaVenta(@PathVariable int id) {
        return ResponseEntity.ok(notaVentaService.getNotaVenta(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<NotaVentaDTO>> getAllNotaVenta() {
        return ResponseEntity.ok(notaVentaService.getAllNotaVenta());
    }
}
