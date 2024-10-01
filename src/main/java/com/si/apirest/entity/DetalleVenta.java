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
@Table(name = "detalle_venta")
public class DetalleVenta {
    @Id
    @GeneratedValue
    private int id;

    private int cantidad; // Cantidad de productos vendidos

    private double precioUnitario; // Precio unitario del producto

    private double total; // Total por la venta de este producto (cantidad * precioUnitario)

    @ManyToOne
    @JoinColumn(name = "id_nota_venta")
    private NotaVenta notaVenta; // Relación con la entidad NotaVenta
}
