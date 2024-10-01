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
@Table(name = "nota_venta")
public class NotaVenta {
    @Id
    @GeneratedValue
    private int id;
    
    private java.util.GregorianCalendar fecha;
    
    private boolean enabled;

    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person person;
    
    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;
    @ManyToOne
    @JoinColumn(name = "id_tipopago")
    private TipoPago tipopago;//

}
