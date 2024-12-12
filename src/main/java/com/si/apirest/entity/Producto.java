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
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue
    private int id;

    private String nombre; // Nombre del producto

    private double precio; // Precio del producto

    private boolean enabled; // Para indicar si el producto está habilitado

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria id_categoria; // Relación con la entidad Categoria

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca id_marca; // Relación con la entidad Marca

    @ManyToOne
    @JoinColumn(name = "id_color")
    private Color id_color; // Relación con la entidad Color

    @ManyToOne
    @JoinColumn(name = "id_talla")
    private Talla id_talla; // Relación con la entidad Talla

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal id_sucursal; // Relación con la entidad Talla

    @ManyToOne
    @JoinColumn(name = "id_descuento")
    private Descuento id_descuento; // Relación con la entidad Talla

    @ManyToOne
    @JoinColumn(name = "id_imagen")
    private Imagen id_imagen; // Relación con la entidad Talla
}
