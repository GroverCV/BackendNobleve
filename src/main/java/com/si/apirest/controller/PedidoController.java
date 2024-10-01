package com.si.apirest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.si.apirest.dto.PedidoDTO;
import com.si.apirest.entity.Pedido;
import com.si.apirest.service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {
    
    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Void> createPedido(@RequestBody @Valid Pedido pedido) {
        pedidoService.createPedido(pedido);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePedido(@PathVariable int id, @RequestBody @Valid PedidoDTO pedidoDTO) {
        pedidoService.updatePedido(pedidoDTO, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable int id) {
        pedidoService.deletePedido(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedido(@PathVariable int id) {
        return ResponseEntity.ok(pedidoService.getPedido(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getAllPedido() {
        return ResponseEntity.ok(pedidoService.getAllPedido());
    }
}
