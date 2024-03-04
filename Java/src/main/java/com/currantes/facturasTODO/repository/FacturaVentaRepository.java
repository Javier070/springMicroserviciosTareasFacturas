package com.currantes.facturasTODO.repository;

import com.currantes.facturasTODO.entities_model.Factura;
import com.currantes.facturasTODO.entities_model.FacturaVenta;
import com.currantes.facturasTODO.entities_model.Proyecto;
import com.currantes.facturasTODO.entities_model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacturaVentaRepository extends JpaRepository<FacturaVenta, Long> {
    List<FacturaVenta> findFacturaVentaByUser(User user);
}
