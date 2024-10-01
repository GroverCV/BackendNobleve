package com.si.apirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.si.apirest.entity.Imagen;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer> {
    // Método para buscar una imagen por su URL (si es necesario)
    Optional<Imagen> findByUrl(String url);
}
