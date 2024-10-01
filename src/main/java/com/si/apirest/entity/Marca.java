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
@Table(name = "marca")
public class Marca {
    @Id
    @GeneratedValue
    private int id;

    private String nombre; // Nombre de la marca

    private boolean enabled; // Para indicar si la marca está habilitada
}
