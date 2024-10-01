package com.si.apirest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "inventario")
public class Inventario {
    @Id
    @GeneratedValue
    private int id;

    private int cantidad; // Cantidad disponible del producto en el inventario

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto; // Relación con la entidad Producto
}
