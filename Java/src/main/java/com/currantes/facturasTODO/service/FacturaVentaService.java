package com.currantes.facturasTODO.service;

import com.currantes.facturasTODO.entities_model.Factura;
import com.currantes.facturasTODO.entities_model.FacturaCompra;
import com.currantes.facturasTODO.entities_model.FacturaVenta;

import java.util.List;

public interface FacturaVentaService {


    public FacturaVenta saveFacturaVenta(FacturaVenta facturaVenta);

    public List<FacturaVenta> listarTodasFacturasFacturaVenta();

    public FacturaVenta obtenerFacturaVentaPorId(Long id);

    public void modificarFacturaVenta(FacturaVenta facturaVenta);

    public  void eliminarFacturaVenta(Long id);



}


