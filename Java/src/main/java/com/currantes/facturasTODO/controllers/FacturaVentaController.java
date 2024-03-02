package com.currantes.facturasTODO.controllers;

import com.currantes.facturasTODO.entities_model.FacturaVenta;
import com.currantes.facturasTODO.service.FacturaVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FacturaVenta")
public class FacturaVentaController {

    @Autowired
    FacturaVentaService facturaVentaService;


    @GetMapping("/buscarPorId/{id}")
    public FacturaVenta obtenerFacturaVentaPorId(@PathVariable Long id){
        return facturaVentaService.obtenerFacturaVentaPorId(id);
    }


    @GetMapping("/todasFacturas")
    public List<FacturaVenta> listarTodasFacturasVenta(){
        return facturaVentaService.listarTodasFacturasFacturaVenta();
    }

    @PostMapping("/crear")
    public void saveFacturaVenta(@RequestBody FacturaVenta facturaVenta){
        facturaVentaService.saveFacturaVenta(facturaVenta);
    }

    @PostMapping("/modificar")
    public void modificarFacturaVenta(@RequestBody FacturaVenta facturaVenta){
        facturaVentaService.modificarFacturaVenta(facturaVenta);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarFacturaVenta(@PathVariable Long id){
        facturaVentaService.eliminarFacturaVenta(id);
    }

}
