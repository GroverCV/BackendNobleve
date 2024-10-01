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
@Table(name = "sucursal")
public class Sucursal {
    @Id
    @GeneratedValue
    private int id;

    private String nombre; // Nombre de la sucursal

    private String direccion; // Dirección de la sucursal

    private String telefono; // Número de teléfono de la sucursal

    private boolean enabled; // Para indicar si la sucursal está habilitada
}
