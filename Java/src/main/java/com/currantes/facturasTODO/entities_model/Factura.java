package com.currantes.facturasTODO.entities_model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Getter
@Setter
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

    @Column
    private String nombre;
    private float baseImporte;
    private  float iva;
    private float total;

    @Temporal(TemporalType.DATE)
    private Date fecha;

   // @ManyToOne




}
