package com.si.apirest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.si.apirest.dto.ProductoDTO;
import com.si.apirest.entity.Producto;
import com.si.apirest.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {
    
    private final ProductoService productoService;

    @PostMapping
    public ResponseEntity<Void> createProducto(@RequestBody @Valid Producto producto) {
        productoService.createProducto(producto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProducto(@PathVariable int id, @RequestBody @Valid ProductoDTO productoDTO) {
        productoService.updateProducto(productoDTO, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable int id) {
        productoService.deleteProducto(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProducto(@PathVariable int id) {
        return ResponseEntity.ok(productoService.getProducto(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getAllProducto() {
        return ResponseEntity.ok(productoService.getAllProducto());
    }
}
