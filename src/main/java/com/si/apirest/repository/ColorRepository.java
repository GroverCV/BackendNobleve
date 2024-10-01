package com.si.apirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.si.apirest.entity.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer> {
    // Método para buscar un color por su nombre (si es necesario)
    Optional<Color> findByNombre(String nombre);
}
