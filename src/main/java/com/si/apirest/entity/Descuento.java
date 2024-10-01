package com.si.apirest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "descuento")
public class Descuento {
    @Id
    @GeneratedValue
    private int id;

    private String descripcion; // Descripción del descuento (ej. "Descuento de temporada")

    private double porcentaje; // Porcentaje de descuento

    private boolean enabled; // Para indicar si el descuento está habilitado
}
