package com.currantes.facturasTODO.service.implService;

import com.currantes.facturasTODO.entities_model.Factura;
import com.currantes.facturasTODO.repository.FacturaRepository;
import com.currantes.facturasTODO.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    FacturaRepository facturaRepository;

    @Override
    public Factura saveFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public List<Factura> listarTodasFacturas() {
        return facturaRepository.findAll();
    }

    @Override
    public Factura obtenerFacturaPorId(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }

    @Override
    public void modificarFactura(Long id, Factura facturaActualizada) {
        Factura factura = facturaRepository.findById(id).orElse(null);
        if (factura != null) {
            factura.setNombre(facturaActualizada.getNombre());
            factura.setBaseImporte(facturaActualizada.getBaseImporte());
            factura.setIva(facturaActualizada.getIva());
            factura.setTotal(facturaActualizada.getTotal());
            factura.setFecha(facturaActualizada.getFecha());
            factura.setUser(facturaActualizada.getUser());
            facturaRepository.save(factura);
        } else {
            throw new IllegalArgumentException("La factura con ID " + id + " no existe.");
        }
    }
    @Override
    public void eliminarFactura(Long id) {
        facturaRepository.deleteById(id);

    }
}
