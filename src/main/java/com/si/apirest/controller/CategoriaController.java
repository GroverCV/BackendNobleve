package com.si.apirest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.si.apirest.dto.CategoriaDTO;
import com.si.apirest.entity.Categoria;
import com.si.apirest.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {
    
    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Void> createCategoria(@RequestBody @Valid Categoria categoria) {
        categoriaService.createCategoria(categoria);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCategoria(@PathVariable int id, @RequestBody @Valid CategoriaDTO categoriaDTO) {
        categoriaService.updateCategoria(categoriaDTO, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable int id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoria(@PathVariable int id) {
        return ResponseEntity.ok(categoriaService.getCategoria(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getAllCategoria() {
        return ResponseEntity.ok(categoriaService.getAllCategoria());
    }
}
