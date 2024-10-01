package com.si.apirest.dto;

import lombok.Data;

@Data
public class DescuentoDTO {
    private int id;
    private String descripcion;
    private double porcentaje;
}
