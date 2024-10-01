package com.si.apirest.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.dto.PedidoDTO;
import com.si.apirest.entity.Pedido;
import com.si.apirest.exceptions.NotFoundException;
import com.si.apirest.repository.PedidoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {

    @Autowired
    private final PedidoRepository pedidoRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public void createPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    public void updatePedido(PedidoDTO pedidoDTO, int id) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
        if (optionalPedido.isPresent()) {
            Pedido updatedPedido = optionalPedido.get();
            modelMapper.map(pedidoDTO, updatedPedido);
            pedidoRepository.save(updatedPedido);
        } else {
            throw new NotFoundException("Pedido no encontrado");
        }
    }

    public void deletePedido(int id) {
        pedidoRepository.deleteById(id);
    }

    public Optional<Pedido> getPedido(int id) {
        return pedidoRepository.findById(id);
    }

    public List<PedidoDTO> getAllPedido() {
        List<Pedido> pedidoList = pedidoRepository.findAll(); 
        List<PedidoDTO> pedidoDTOs = new ArrayList<>();
        for (Pedido pedido : pedidoList) {
            pedidoDTOs.add(modelMapper.map(pedido, PedidoDTO.class));
        }
        return pedidoDTOs;
    }
}
