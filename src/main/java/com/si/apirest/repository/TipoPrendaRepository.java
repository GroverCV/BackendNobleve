package com.si.apirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.si.apirest.entity.TipoPrenda;

@Repository
public interface TipoPrendaRepository extends JpaRepository<TipoPrenda, Integer> {
    // Método para buscar un tipo de prenda por su nombre (si es necesario)
    Optional<TipoPrenda> findByNombre(String nombre);
}
