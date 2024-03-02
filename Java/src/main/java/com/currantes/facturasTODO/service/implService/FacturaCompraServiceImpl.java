package com.currantes.facturasTODO.service.implService;

import com.currantes.facturasTODO.entities_model.FacturaCompra;
import com.currantes.facturasTODO.repository.FacturaCompraRepository;
import com.currantes.facturasTODO.service.FacturaCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaCompraServiceImpl implements FacturaCompraService {
    @Autowired
    FacturaCompraRepository facturaCompraRepository;

    @Override
    public FacturaCompra saveFacturaCompra(FacturaCompra facturaCompra) {
        return facturaCompraRepository.save(facturaCompra);
    }

    @Override
    public List<FacturaCompra> listarTodasFacturasCompra() {
        return facturaCompraRepository.findAll();
    }

    @Override
    public FacturaCompra obtenerFacturaCompraPorId(Long id) {
        return facturaCompraRepository.findById(id).orElseThrow();
    }

    @Override
    public void modificarFacturaCompra(FacturaCompra facturaCompra) {
        if (facturaCompraRepository.findById(facturaCompra.getIdFacturaCompra()).isPresent()) {
            facturaCompraRepository.save(facturaCompra);
        } else {
            throw new IllegalArgumentException("La factura de compra con ID " + facturaCompra.getIdFacturaCompra() + " no existe.");
        }
    }

//
//    @Override
//    public void modificarFacturaCompra(FacturaCompra facturaCompraActualizada) {
//        FacturaCompra facturaCompra = facturaCompraRepository.findById(id).orElseThrow();
//        if (facturaCompra != null) {
//            facturaCompra.setNombre(facturaCompraActualizada.getNombre());
//            facturaCompra.setBaseImporte(facturaCompraActualizada.getBaseImporte());
//            facturaCompra.setIva(facturaCompraActualizada.getIva());
//            facturaCompra.setTotal(facturaCompraActualizada.getTotal());
//            facturaCompra.setFecha(facturaCompraActualizada.getFecha());
//            facturaCompra.setUser(facturaCompraActualizada.getUser());
//            facturaCompraRepository.save(facturaCompra);
//        } else {
//            throw new IllegalArgumentException("La factura venta con ID " + id + " no existe.");
//        }
//    }


    @Override
    public void eliminarFacturaCompra(Long id) {
        facturaCompraRepository.deleteById(id);
    }



}
