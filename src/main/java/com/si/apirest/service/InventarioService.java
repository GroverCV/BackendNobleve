package com.si.apirest.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.dto.InventarioDTO;
import com.si.apirest.entity.Inventario;
import com.si.apirest.exceptions.NotFoundException;
import com.si.apirest.repository.InventarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventarioService {

    @Autowired
    private final InventarioRepository inventarioRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public void createInventario(Inventario inventario) {
        inventarioRepository.save(inventario);
    }

    public void updateInventario(InventarioDTO inventarioDTO, int id) {
        Optional<Inventario> optionalInventario = inventarioRepository.findById(id);
        if (optionalInventario.isPresent()) {
            Inventario updatedInventario = optionalInventario.get();
            modelMapper.map(inventarioDTO, updatedInventario);
            inventarioRepository.save(updatedInventario);
        } else {
            throw new NotFoundException("Inventario no encontrado");
        }
    }

    public void deleteInventario(int id) {
        inventarioRepository.deleteById(id);
    }

    public Optional<Inventario> getInventario(int id) {
        return inventarioRepository.findById(id);
    }

    public List<InventarioDTO> getAllInventario() {
        List<Inventario> inventarioList = inventarioRepository.findAll(); 
        List<InventarioDTO> inventarioDTOs = new ArrayList<>();
        for (Inventario inventario : inventarioList) {
            inventarioDTOs.add(modelMapper.map(inventario, InventarioDTO.class));
        }
        return inventarioDTOs;
    }
}
