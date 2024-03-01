package com.currantes.facturasTODO.entities_model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "factura_compra")
@Data
public class FacturaCompra{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacturaCompra;

    @Column
    private String nombre;
    private float baseImporte;
    private float iva;
    private float total = baseImporte + iva;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name ="id_proveedor", nullable = false)
    private Proveedor proveedor;

}
