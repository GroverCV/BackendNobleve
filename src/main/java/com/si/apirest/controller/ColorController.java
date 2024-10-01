package com.si.apirest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.si.apirest.dto.ColorDTO;
import com.si.apirest.entity.Color;
import com.si.apirest.service.ColorService;

import java.util.List;

@RestController
@RequestMapping("/color")
@RequiredArgsConstructor
public class ColorController {
    
    private final ColorService colorService;

    @PostMapping
    public ResponseEntity<Void> createColor(@RequestBody @Valid Color color) {
        colorService.createColor(color);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateColor(@PathVariable int id, @RequestBody @Valid ColorDTO colorDTO) {
        colorService.updateColor(colorDTO, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColor(@PathVariable int id) {
        colorService.deleteColor(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Color> getColor(@PathVariable int id) {
        return ResponseEntity.ok(colorService.getColor(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<ColorDTO>> getAllColor() {
        return ResponseEntity.ok(colorService.getAllColor());
    }
}
