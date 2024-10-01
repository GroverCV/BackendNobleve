package com.si.apirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.si.apirest.entity.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {
    // Método para buscar una marca por su nombre (si es necesario)
    Optional<Marca> findByNombre(String nombre);
}
