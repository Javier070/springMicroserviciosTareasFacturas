package com.currantes.facturasTODO.entities_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@JsonIgnoreProperties({ "factura_compra", "facturasCompra"})



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
