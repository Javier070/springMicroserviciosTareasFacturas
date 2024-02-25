package com.currantes.facturasTODO.repository;

import com.currantes.facturasTODO.entities_model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository <Factura, Long> {
}
