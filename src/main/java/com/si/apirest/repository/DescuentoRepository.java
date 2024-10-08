package com.si.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.si.apirest.entity.Descuento;

@Repository
public interface DescuentoRepository extends JpaRepository<Descuento, Integer> {
 
}