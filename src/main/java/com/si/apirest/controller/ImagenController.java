package com.si.apirest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.si.apirest.dto.ImagenDTO;
import com.si.apirest.entity.Imagen;
import com.si.apirest.service.ImagenService;

import java.util.List;

@RestController
@RequestMapping("/imagen")
@RequiredArgsConstructor
public class ImagenController {
    
    private final ImagenService imagenService;

    @PostMapping
    public ResponseEntity<Void> createImagen(@RequestBody @Valid Imagen imagen) {
        imagenService.createImagen(imagen);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateImagen(@PathVariable int id, @RequestBody @Valid ImagenDTO imagenDTO) {
        imagenService.updateImagen(imagenDTO, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImagen(@PathVariable int id) {
        imagenService.deleteImagen(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imagen> getImagen(@PathVariable int id) {
        return ResponseEntity.ok(imagenService.getImagen(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<ImagenDTO>> getAllImagen() {
        return ResponseEntity.ok(imagenService.getAllImagen());
    }
}
