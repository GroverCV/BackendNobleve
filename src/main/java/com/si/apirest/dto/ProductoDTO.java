package com.si.apirest.dto;

import lombok.Data;

@Data
public class ProductoDTO {
    private int id;
    private String nombre;
    private double precio;
    private String descripcion;
}
