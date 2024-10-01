package com.si.apirest.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.dto.SucursalDTO;
import com.si.apirest.entity.Sucursal;
import com.si.apirest.exceptions.NotFoundException;
import com.si.apirest.repository.SucursalRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SucursalService {

    @Autowired
    private final SucursalRepository sucursalRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public void createSucursal(Sucursal sucursal) {
        sucursalRepository.save(sucursal);
    }

    public void updateSucursal(SucursalDTO sucursalDTO, int id) {
        Optional<Sucursal> optionalSucursal = sucursalRepository.findById(id);
        if (optionalSucursal.isPresent()) {
            Sucursal updatedSucursal = optionalSucursal.get();
            modelMapper.map(sucursalDTO, updatedSucursal);
            sucursalRepository.save(updatedSucursal);
        } else {
            throw new NotFoundException("Sucursal no encontrada");
        }
    }

    public void deleteSucursal(int id) {
        sucursalRepository.deleteById(id);
    }

    public Optional<Sucursal> getSucursal(int id) {
        return sucursalRepository.findById(id);
    }

    public List<SucursalDTO> getAllSucursal() {
        List<Sucursal> sucursalList = sucursalRepository.findAll(); 
        List<SucursalDTO> sucursalDTOs = new ArrayList<>();
        for (Sucursal sucursal : sucursalList) {
            sucursalDTOs.add(modelMapper.map(sucursal, SucursalDTO.class));
        }
        return sucursalDTOs;
    }
}
