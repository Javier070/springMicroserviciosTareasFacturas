package com.currantes.facturasTODO.entities_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Getter
@Setter
public abstract  class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

    @Column
    private String nombre;
    private float baseImporte;
    private  float iva;
    private float total = baseImporte + iva;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @JsonIgnoreProperties("Factura")
    @ManyToOne
    @JoinColumn( name ="id_user",nullable = false)
    private User user;


}
