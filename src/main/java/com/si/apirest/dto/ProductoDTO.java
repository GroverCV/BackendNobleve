package com.si.apirest.dto;

import lombok.Data;

@Data
public class ProductoDTO {
    private int id;
    private String nombre;
    private double precio;
    private CategoriaDTO id_categoria;  // Cambiado de id_categoria a objeto CategoriaDTO
    private ColorDTO id_color;  // Cambiado de id_color a objeto ColorDTO
    private DescuentoDTO id_descuento;  // Cambiado de id_descuento a objeto DescuentoDTO
    private ImagenDTO id_imagen;  // Cambiado de id_imagen a objeto ImagenDTO
    private SucursalDTO id_sucursal;  // Cambiado de id_sucursal a objeto SucursalDTO
    private TallaDTO id_talla;  // Cambiado de id_talla a objeto TallaDTO
    private MarcaDTO id_marca;  // Cambiado de id_marca a objeto MarcaDTO
}
