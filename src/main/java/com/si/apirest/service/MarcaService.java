package com.si.apirest.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.dto.MarcaDTO;
import com.si.apirest.entity.Marca;
import com.si.apirest.exceptions.NotFoundException;
import com.si.apirest.repository.MarcaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MarcaService {

    @Autowired
    private final MarcaRepository marcaRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public void createMarca(Marca marca) {
        marcaRepository.save(marca);
    }

    public void updateMarca(MarcaDTO marcaDTO, int id) {
        Optional<Marca> optionalMarca = marcaRepository.findById(id);
        if (optionalMarca.isPresent()) {
            Marca updatedMarca = optionalMarca.get();
            modelMapper.map(marcaDTO, updatedMarca);
            marcaRepository.save(updatedMarca);
        } else {
            throw new NotFoundException("Marca no encontrada");
        }
    }

    public void deleteMarca(int id) {
        marcaRepository.deleteById(id);
    }

    public Optional<Marca> getMarca(int id) {
        return marcaRepository.findById(id);
    }

    public List<MarcaDTO> getAllMarca() {
        List<Marca> marcaList = marcaRepository.findAll(); 
        List<MarcaDTO> marcaDTOs = new ArrayList<>();
        for (Marca marca : marcaList) {
            marcaDTOs.add(modelMapper.map(marca, MarcaDTO.class));
        }
        return marcaDTOs;
    }
}
