package com.si.apirest.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.dto.DescuentoDTO;
import com.si.apirest.entity.Descuento;
import com.si.apirest.exceptions.NotFoundException;
import com.si.apirest.repository.DescuentoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DescuentoService {

    @Autowired
    private final DescuentoRepository descuentoRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public void createDescuento(Descuento descuento) {
        descuentoRepository.save(descuento);
    }

    public void updateDescuento(DescuentoDTO descuentoDTO, int id) {
        Optional<Descuento> optionalDescuento = descuentoRepository.findById(id);
        if (optionalDescuento.isPresent()) {
            Descuento updatedDescuento = optionalDescuento.get();
            modelMapper.map(descuentoDTO, updatedDescuento);
            descuentoRepository.save(updatedDescuento);
        } else {
            throw new NotFoundException("Descuento no encontrado");
        }
    }

    public void deleteDescuento(int id) {
        descuentoRepository.deleteById(id);
    }

    public Optional<Descuento> getDescuento(int id) {
        return descuentoRepository.findById(id);
    }

    public List<DescuentoDTO> getAllDescuento() {
        List<Descuento> descuentoList = descuentoRepository.findAll(); 
        List<DescuentoDTO> descuentoDTOs = new ArrayList<>();
        for (Descuento descuento : descuentoList) {
            descuentoDTOs.add(modelMapper.map(descuento, DescuentoDTO.class));
        }
        return descuentoDTOs;
    }
}
