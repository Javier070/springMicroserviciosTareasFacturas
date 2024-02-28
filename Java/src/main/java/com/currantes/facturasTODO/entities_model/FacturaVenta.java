package com.currantes.facturasTODO.entities_model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class FacturaVenta extends Factura {
    @ManyToOne
    @JoinColumn(name ="id_cliente", nullable = false)
    private Cliente cliente;
}
