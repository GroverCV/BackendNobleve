package com.si.apirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.si.apirest.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // Método para buscar un producto por su nombre (si es necesario)
    Optional<Producto> findByNombre(String nombre);
}
