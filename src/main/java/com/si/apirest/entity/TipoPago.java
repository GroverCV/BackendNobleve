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
@Table(name = "tipo_pago")
public class TipoPago {
    @Id
    @GeneratedValue
    private int id;

    private String nombre; // Nombre del tipo de pago

    private String descripcion; // Descripción del tipo de pago

    private boolean enabled; // Para indicar si el tipo de pago está habilitado
}
