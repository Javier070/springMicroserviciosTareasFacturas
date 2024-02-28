package com.currantes.facturasTODO.controllers;

import com.currantes.facturasTODO.entities_model.Factura;
import com.currantes.facturasTODO.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    FacturaService facturaService;

    @GetMapping("/buscarPorId/{id}")
    public Factura obtenerFacturaPorId (@PathVariable Long id){
        return facturaService.obtenerFacturaPorId(id);
    }

    @GetMapping("/todaFacturas")
        public List<Factura> listarTodasFacturas(){
        return facturaService.listarTodasFacturas();
    }




    @PostMapping("/crear")
    public Factura saveFactura(@RequestBody Factura factura){
        return  facturaService.saveFactura(factura);
    }

    @PostMapping("/modificar/{id}")
    public void modificarFactura(@PathVariable Long id, @RequestBody Factura facturaActualizada) {
        facturaService.modificarFactura(id, facturaActualizada);
    }



    @DeleteMapping("/eliminar/{id}")
    public void eliminarFactura(@PathVariable Long id){
        facturaService.eliminarFactura(id);
    }

}

