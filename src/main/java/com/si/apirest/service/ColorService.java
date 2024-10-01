package com.si.apirest.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.dto.ColorDTO;
import com.si.apirest.entity.Color;
import com.si.apirest.exceptions.NotFoundException;
import com.si.apirest.repository.ColorRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColorService {

    @Autowired
    private final ColorRepository colorRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public void createColor(Color color) {
        colorRepository.save(color);
    }

    public void updateColor(ColorDTO colorDTO, int id) {
        Optional<Color> optionalColor = colorRepository.findById(id);
        if (optionalColor.isPresent()) {
            Color updatedColor = optionalColor.get();
            modelMapper.map(colorDTO, updatedColor);
            colorRepository.save(updatedColor);
        } else {
            throw new NotFoundException("Color no encontrado");
        }
    }

    public void deleteColor(int id) {
        colorRepository.deleteById(id);
    }

    public Optional<Color> getColor(int id) {
        return colorRepository.findById(id);
    }

    public List<ColorDTO> getAllColor() {
        List<Color> colorList = colorRepository.findAll(); 
        List<ColorDTO> colorDTOs = new ArrayList<>();
        for (Color color : colorList) {
            colorDTOs.add(modelMapper.map(color, ColorDTO.class));
        }
        return colorDTOs;
    }
}
