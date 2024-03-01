package com.currantes.facturasTODO.service.implService;

import com.currantes.facturasTODO.entities_model.Factura;
import com.currantes.facturasTODO.entities_model.FacturaCompra;
import com.currantes.facturasTODO.entities_model.FacturaVenta;
import com.currantes.facturasTODO.repository.FacturaVentaRepository;
import com.currantes.facturasTODO.service.FacturaVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacturaVentaServiceImpl implements FacturaVentaService {

    @Autowired
    FacturaVentaRepository facturaVentaRepository;


    @Override
    public FacturaVenta saveFacturaVenta (FacturaVenta facturaVenta) {
        return facturaVentaRepository.save(facturaVenta);
    }

    @Override
    public List<FacturaVenta> listarTodasFacturasFacturaVentas() {
        return facturaVentaRepository.findAll();
    }

    @Override
    public FacturaVenta obtenerFacturaVentaPorId(Long id) {
        return facturaVentaRepository.findById(id).orElseThrow();
    }

    @Override
    public void modificarFacturaVenta(Long id, Factura facturaVentaActualizada) {
        FacturaVenta facturaVenta = facturaVentaRepository.findById(id).orElseThrow();
        if (facturaVenta != null) {
            facturaVenta.setNombre(facturaVentaActualizada.getNombre());
            facturaVenta.setBaseImporte(facturaVentaActualizada.getBaseImporte());
            facturaVenta.setIva(facturaVentaActualizada.getIva());
            facturaVenta.setTotal(facturaVentaActualizada.getTotal());
            facturaVenta.setFecha(facturaVentaActualizada.getFecha());
            facturaVenta.setUser(facturaVentaActualizada.getUser());
            facturaVentaRepository.save(facturaVenta);
        } else {
            throw new IllegalArgumentException("La factura compra con ID " + id + " no existe.");
        }
    }

    @Override
    public void eliminarFacturaVenta(Long id) {
        facturaVentaRepository.deleteById(id);

    }
}
