package com.currantes.facturasTODO.repository;

import com.currantes.facturasTODO.entities_model.Factura;
import com.currantes.facturasTODO.entities_model.FacturaVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaVentaRepository extends JpaRepository<FacturaVenta, Long> {
}
