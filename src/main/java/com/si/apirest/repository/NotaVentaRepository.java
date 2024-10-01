package com.si.apirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.si.apirest.entity.NotaVenta;

@Repository
public interface NotaVentaRepository extends JpaRepository<NotaVenta, Integer> {
    // Método para buscar una nota de venta por su ID (si es necesario)
    Optional<NotaVenta> findById(int id);
}
