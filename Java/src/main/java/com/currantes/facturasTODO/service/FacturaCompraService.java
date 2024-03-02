package com.currantes.facturasTODO.service;

import com.currantes.facturasTODO.entities_model.FacturaCompra;

import java.util.List;

public interface FacturaCompraService {


    public FacturaCompra saveFacturaCompra(FacturaCompra facturaCompra);

    public List<FacturaCompra> listarTodasFacturasCompra();

    public FacturaCompra obtenerFacturaCompraPorId(Long id);

    public void modificarFacturaCompra(FacturaCompra facturaCompra);

    public  void eliminarFacturaCompra(Long id);


}
