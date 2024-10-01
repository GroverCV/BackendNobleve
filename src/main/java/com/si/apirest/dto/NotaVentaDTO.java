package com.si.apirest.dto;

import java.util.GregorianCalendar;

import lombok.Data;
@Data

public class NotaVentaDTO {
    private int id;
    private GregorianCalendar fecha;
    private boolean enabled;
}
