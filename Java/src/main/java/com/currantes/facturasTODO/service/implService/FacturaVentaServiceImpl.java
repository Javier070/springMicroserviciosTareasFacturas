package com.currantes.facturasTODO.service.implService;

import com.currantes.facturasTODO.entities_model.Factura;
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
        calcularTotalVenta(facturaVenta);
        return facturaVentaRepository.save(facturaVenta);
    }

    @Override
    public List<FacturaVenta> listarTodasFacturasFacturaVenta() {
        return facturaVentaRepository.findAll();
    }

    @Override
    public FacturaVenta obtenerFacturaVentaPorId(Long id) {
        return facturaVentaRepository.findById(id).orElseThrow();
    }



    @Override
    public void modificarFacturaVenta(FacturaVenta facturaVenta) {
        if (facturaVentaRepository.findById(facturaVenta.getIdFacturaVenta()).isPresent()) {
            calcularTotalVenta(facturaVenta);
            facturaVentaRepository.save(facturaVenta);
        } else {
            throw new IllegalArgumentException("La factura de compra con ID " + facturaVenta.getIdFacturaVenta() + " no existe.");
        }
    }

    @Override
    public void eliminarFacturaVenta(Long id) {
        facturaVentaRepository.deleteById(id);

    }

    private void calcularTotalVenta(FacturaVenta facturaVenta) {
        float total = facturaVenta.getBaseImporte() - facturaVenta.getIva();
        facturaVenta.setTotal(total);
    }
}
