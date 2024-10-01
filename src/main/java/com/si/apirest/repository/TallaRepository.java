package com.si.apirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.si.apirest.entity.Talla;

@Repository
public interface TallaRepository extends JpaRepository<Talla, Integer> {
    // Método para buscar una talla por su nombre (si es necesario)
    Optional<Talla> findByNombre(String nombre);
}
