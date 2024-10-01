package com.si.apirest.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.dto.TipoPrendaDTO;
import com.si.apirest.entity.TipoPrenda;
import com.si.apirest.exceptions.NotFoundException;
import com.si.apirest.repository.TipoPrendaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoPrendaService {

    @Autowired
    private final TipoPrendaRepository tipoPrendaRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public void createTipoPrenda(TipoPrenda tipoPrenda) {
        tipoPrendaRepository.save(tipoPrenda);
    }

    public void updateTipoPrenda(TipoPrendaDTO tipoPrendaDTO, int id) {
        Optional<TipoPrenda> optionalTipoPrenda = tipoPrendaRepository.findById(id);
        if (optionalTipoPrenda.isPresent()) {
            TipoPrenda updatedTipoPrenda = optionalTipoPrenda.get();
            modelMapper.map(tipoPrendaDTO, updatedTipoPrenda);
            tipoPrendaRepository.save(updatedTipoPrenda);
        } else {
            throw new NotFoundException("Tipo de prenda no encontrado");
        }
    }

    public void deleteTipoPrenda(int id) {
        tipoPrendaRepository.deleteById(id);
    }

    public Optional<TipoPrenda> getTipoPrenda(int id) {
        return tipoPrendaRepository.findById(id);
    }

    public List<TipoPrendaDTO> getAllTipoPrenda() {
        List<TipoPrenda> tipoPrendaList = tipoPrendaRepository.findAll(); 
        List<TipoPrendaDTO> tipoPrendaDTOs = new ArrayList<>();
        for (TipoPrenda tipoPrenda : tipoPrendaList) {
            tipoPrendaDTOs.add(modelMapper.map(tipoPrenda, TipoPrendaDTO.class));
        }
        return tipoPrendaDTOs;
    }
}
