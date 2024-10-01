package com.si.apirest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.si.apirest.dto.TipoPagoDTO;
import com.si.apirest.entity.TipoPago;
import com.si.apirest.service.TipoPagoService;

import java.util.List;

@RestController
@RequestMapping("/tipopago")
@RequiredArgsConstructor
public class TipoPagoController {
    
    private final TipoPagoService tipoPagoService;

    @PostMapping
    public ResponseEntity<Void> createTipoPago(@RequestBody @Valid TipoPago tipoPago) {
        tipoPagoService.createTipoPago(tipoPago);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTipoPago(@PathVariable int id, @RequestBody @Valid TipoPagoDTO tipoPagoDTO) {
        tipoPagoService.updateTipoPago(tipoPagoDTO, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoPago(@PathVariable int id) {
        tipoPagoService.deleteTipoPago(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPago> getTipoPago(@PathVariable int id) {
        return ResponseEntity.ok(tipoPagoService.getTipoPago(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<TipoPagoDTO>> getAllTipoPago() {
        return ResponseEntity.ok(tipoPagoService.getAllTipoPago());
    }
}
