package com.si.apirest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.dto.TipoPagoDTO;
import com.si.apirest.entity.TipoPago;
import com.si.apirest.exceptions.NotFoundException;
import com.si.apirest.repository.TipoPagoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoPagoService {

    @Autowired
    private final TipoPagoRepository tipoPagoRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public void createTipoPago(TipoPago tipoPago) {
        tipoPagoRepository.save(tipoPago);
    }

    public void updateTipoPago(TipoPagoDTO tipoPagoDTO, int id) {
        Optional<TipoPago> optionalTipoPago = tipoPagoRepository.findById(id);
        if (optionalTipoPago.isPresent()) {
            TipoPago updatedTipoPago = optionalTipoPago.get();
            modelMapper.map(tipoPagoDTO, updatedTipoPago);
            tipoPagoRepository.save(updatedTipoPago);
        } else {
            throw new NotFoundException("Tipo de Pago no encontrado");
        }
    }

    public void deleteTipoPago(int id) {
        tipoPagoRepository.deleteById(id);
    }

    public Optional<TipoPago> getTipoPago(int id) {
        return tipoPagoRepository.findById(id);
    }

    public List<TipoPagoDTO> getAllTipoPago() {
        List<TipoPago> tipoPagoList = tipoPagoRepository.findAll(); 
        List<TipoPagoDTO> tipoPagoDTOs = new ArrayList<>();
        for (TipoPago tipoPago : tipoPagoList) {
            tipoPagoDTOs.add(modelMapper.map(tipoPago, TipoPagoDTO.class));
        }
        return tipoPagoDTOs;
    }
}
