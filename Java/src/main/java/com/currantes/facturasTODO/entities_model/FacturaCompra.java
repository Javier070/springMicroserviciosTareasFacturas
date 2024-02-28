package com.currantes.facturasTODO.entities_model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class FacturaCompra extends  Factura{
    @ManyToOne
    @JoinColumn(name ="id_proveedor", nullable = false)
    private Proveedor proveedor;

}
