package com.si.apirest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.dto.ProductoDTO;
import com.si.apirest.entity.Producto;
import com.si.apirest.exceptions.NotFoundException;
import com.si.apirest.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {

    @Autowired
    private final ProductoRepository productoRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public void createProducto(Producto producto) {
        productoRepository.save(producto);
    }

    public void updateProducto(ProductoDTO productoDTO, int id) {
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        if (optionalProducto.isPresent()) {
            Producto updatedProducto = optionalProducto.get();
            modelMapper.map(productoDTO, updatedProducto);
            productoRepository.save(updatedProducto);
        } else {
            throw new NotFoundException("Producto no encontrado");
        }
    }

    public void deleteProducto(int id) {
        productoRepository.deleteById(id);
    }

    public Optional<Producto> getProducto(int id) {
        return productoRepository.findById(id);
    }

    public List<ProductoDTO> getAllProducto() {
        List<Producto> productoList = productoRepository.findAll(); 
        List<ProductoDTO> productoDTOs = new ArrayList<>();
        for (Producto producto : productoList) {
            productoDTOs.add(modelMapper.map(producto, ProductoDTO.class));
        }
        return productoDTOs;
    }
}
