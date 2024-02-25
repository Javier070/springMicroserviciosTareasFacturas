package com.currantes.facturasTODO.service;

import com.currantes.facturasTODO.entities_model.Factura;

import java.util.List;

public interface FacturaService {

    public Factura saveFactura(Factura factura);

    public List<Factura> listarTodasFacturas();

    public Factura obtenerFacturaPorId(Long id);

    public void modificarFactura(Long id, Factura facturaActualizada);

    public  void eliminarFactura(Long id);
}
