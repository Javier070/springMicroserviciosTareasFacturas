package com.currantes.facturasTODO.entities_model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Proveedor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;
    @Column(nullable = true, length = 600)
    private String nombre;



  //   Relación con FacturaCompra


    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<FacturaCompra> facturasCompra;
}
