package com.currantes.facturasTODO.entities_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter

public  class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;
    private float baseImporte;
    private float iva;
    private float total = baseImporte + iva;



    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "tipo_factura", insertable = false, updatable = false)
    private String tipoFactura; // Esta es la columna que indica el tipo de factura


    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
}