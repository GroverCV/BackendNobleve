package com.si.apirest.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.dto.TallaDTO;
import com.si.apirest.entity.Talla;
import com.si.apirest.exceptions.NotFoundException;
import com.si.apirest.repository.TallaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TallaService {

    @Autowired
    private final TallaRepository tallaRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public void createTalla(Talla talla) {
        tallaRepository.save(talla);
    }

    public void updateTalla(TallaDTO tallaDTO, int id) {
        Optional<Talla> optionalTalla = tallaRepository.findById(id);
        if (optionalTalla.isPresent()) {
            Talla updatedTalla = optionalTalla.get();
            modelMapper.map(tallaDTO, updatedTalla);
            tallaRepository.save(updatedTalla);
        } else {
            throw new NotFoundException("Talla no encontrada");
        }
    }

    public void deleteTalla(int id) {
        tallaRepository.deleteById(id);
    }

    public Optional<Talla> getTalla(int id) {
        return tallaRepository.findById(id);
    }

    public List<TallaDTO> getAllTalla() {
        List<Talla> tallaList = tallaRepository.findAll(); 
        List<TallaDTO> tallaDTOs = new ArrayList<>();
        for (Talla talla : tallaList) {
            tallaDTOs.add(modelMapper.map(talla, TallaDTO.class));
        }
        return tallaDTOs;
    }
}
