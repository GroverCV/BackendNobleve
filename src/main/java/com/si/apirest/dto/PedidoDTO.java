package com.si.apirest.dto;

import lombok.Data;

@Data
public class PedidoDTO {
    private int id;
    private String direccion;
    private String enlace;
    private String descripcion;
}