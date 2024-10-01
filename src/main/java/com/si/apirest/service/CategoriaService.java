package com.si.apirest.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.dto.CategoriaDTO;
import com.si.apirest.entity.Categoria;
import com.si.apirest.exceptions.NotFoundException;
import com.si.apirest.repository.CategoriaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    @Autowired
    private final CategoriaRepository categoriaRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public void createCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public void updateCategoria(CategoriaDTO categoriaDTO, int id) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        if (optionalCategoria.isPresent()) {
            Categoria updatedCategoria = optionalCategoria.get();
            modelMapper.map(categoriaDTO, updatedCategoria);
            categoriaRepository.save(updatedCategoria);
        } else {
            throw new NotFoundException("Categoría no encontrada");
        }
    }

    public void deleteCategoria(int id) {
        categoriaRepository.deleteById(id);
    }

    public Optional<Categoria> getCategoria(int id) {
        return categoriaRepository.findById(id);
    }

    public List<CategoriaDTO> getAllCategoria() {
        List<Categoria> categoriaList = categoriaRepository.findAll(); 
        List<CategoriaDTO> categoriaDTOs = new ArrayList<>();
        for (Categoria categoria : categoriaList) {
            categoriaDTOs.add(modelMapper.map(categoria, CategoriaDTO.class));
        }
        return categoriaDTOs;
    }
}
