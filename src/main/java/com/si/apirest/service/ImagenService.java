package com.si.apirest.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.dto.ImagenDTO;
import com.si.apirest.entity.Imagen;
import com.si.apirest.exceptions.NotFoundException;
import com.si.apirest.repository.ImagenRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImagenService {

    @Autowired
    private final ImagenRepository imagenRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public void createImagen(Imagen imagen) {
        imagenRepository.save(imagen);
    }

    public void updateImagen(ImagenDTO imagenDTO, int id) {
        Optional<Imagen> optionalImagen = imagenRepository.findById(id);
        if (optionalImagen.isPresent()) {
            Imagen updatedImagen = optionalImagen.get();
            modelMapper.map(imagenDTO, updatedImagen);
            imagenRepository.save(updatedImagen);
        } else {
            throw new NotFoundException("Imagen no encontrada");
        }
    }

    public void deleteImagen(int id) {
        imagenRepository.deleteById(id);
    }

    public Optional<Imagen> getImagen(int id) {
        return imagenRepository.findById(id);
    }

    public List<ImagenDTO> getAllImagen() {
        List<Imagen> imagenList = imagenRepository.findAll(); 
        List<ImagenDTO> imagenDTOs = new ArrayList<>();
        for (Imagen imagen : imagenList) {
            imagenDTOs.add(modelMapper.map(imagen, ImagenDTO.class));
        }
        return imagenDTOs;
    }
}
