package com.si.apirest.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.dto.DetalleVentaDTO;
import com.si.apirest.entity.DetalleVenta;
import com.si.apirest.exceptions.NotFoundException;
import com.si.apirest.repository.DetalleVentaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetalleVentaService {

    @Autowired
    private final DetalleVentaRepository detalleVentaRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public void createDetalleVenta(DetalleVenta detalleVenta) {
        detalleVentaRepository.save(detalleVenta);
    }

    public void updateDetalleVenta(DetalleVentaDTO detalleVentaDTO, int id) {
        Optional<DetalleVenta> optionalDetalleVenta = detalleVentaRepository.findById(id);
        if (optionalDetalleVenta.isPresent()) {
            DetalleVenta updatedDetalleVenta = optionalDetalleVenta.get();
            modelMapper.map(detalleVentaDTO, updatedDetalleVenta);
            detalleVentaRepository.save(updatedDetalleVenta);
        } else {
            throw new NotFoundException("Detalle de venta no encontrado");
        }
    }

    public void deleteDetalleVenta(int id) {
        detalleVentaRepository.deleteById(id);
    }

    public Optional<DetalleVenta> getDetalleVenta(int id) {
        return detalleVentaRepository.findById(id);
    }

    public List<DetalleVentaDTO> getAllDetalleVenta() {
        List<DetalleVenta> detalleVentaList = detalleVentaRepository.findAll(); 
        List<DetalleVentaDTO> detalleVentaDTOs = new ArrayList<>();
        for (DetalleVenta detalleVenta : detalleVentaList) {
            detalleVentaDTOs.add(modelMapper.map(detalleVenta, DetalleVentaDTO.class));
        }
        return detalleVentaDTOs;
    }
}
