package com.si.apirest.entity;

import java.util.GregorianCalendar;
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
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue
    private int id;

    private String direccion;
    
    private String enlace;

    private String descripcion;

    private GregorianCalendar fecha; // Suponiendo que también quieres almacenar la fecha del pedido

    private boolean enabled; // Para indicar si el pedido está habilitado

    @ManyToOne
    @JoinColumn(name = "id_notaventa")
    private NotaVenta notaVenta; // Relación con la entidad Sucursal

    // Puedes agregar más relaciones o atributos si es necesario
}
