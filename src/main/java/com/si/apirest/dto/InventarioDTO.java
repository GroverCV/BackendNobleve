package com.si.apirest.dto;

import lombok.Data;

@Data
public class InventarioDTO {
    private int id;
    private int cantidad;
    private ProductoDTO id_producto;
} 
