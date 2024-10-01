package com.si.apirest.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.dto.NotaVentaDTO;
import com.si.apirest.entity.NotaVenta;
import com.si.apirest.exceptions.NotFoundException;
import com.si.apirest.repository.NotaVentaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotaVentaService {

    @Autowired
    private final NotaVentaRepository notaVentaRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public void createNotaVenta(NotaVenta notaVenta) {
        notaVentaRepository.save(notaVenta);
    }

    public void updateNotaVenta(NotaVentaDTO notaVentaDTO, int id) {
        Optional<NotaVenta> optionalNotaVenta = notaVentaRepository.findById(id);
        if (optionalNotaVenta.isPresent()) {
            NotaVenta updatedNotaVenta = optionalNotaVenta.get();
            modelMapper.map(notaVentaDTO, updatedNotaVenta);
            notaVentaRepository.save(updatedNotaVenta);
        } else {
            throw new NotFoundException("Nota de venta no encontrada");
        }
    }

    public void deleteNotaVenta(int id) {
        notaVentaRepository.deleteById(id);
    }

    public Optional<NotaVenta> getNotaVenta(int id) {
        return notaVentaRepository.findById(id);
    }

    public List<NotaVentaDTO> getAllNotaVenta() {
        List<NotaVenta> notaVentaList = notaVentaRepository.findAll(); 
        List<NotaVentaDTO> notaVentaDTOs = new ArrayList<>();
        for (NotaVenta notaVenta : notaVentaList) {
            notaVentaDTOs.add(modelMapper.map(notaVenta, NotaVentaDTO.class));
        }
        return notaVentaDTOs;
    }
}
