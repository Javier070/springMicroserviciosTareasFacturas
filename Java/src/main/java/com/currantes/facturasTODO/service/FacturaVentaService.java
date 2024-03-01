package com.currantes.facturasTODO.service;

import com.currantes.facturasTODO.entities_model.Factura;
import com.currantes.facturasTODO.entities_model.FacturaVenta;

import java.util.List;

public interface FacturaVentaService {


    public FacturaVenta saveFacturaVenta(FacturaVenta facturaVenta);

    public List<FacturaVenta> listarTodasFacturasFacturaVentas();

    public FacturaVenta obtenerFacturaVentaPorId(Long id);

    public void modificarFacturaVenta(Long id, Factura facturaActualizada);

    public  void eliminarFacturaVenta(Long id);
}
