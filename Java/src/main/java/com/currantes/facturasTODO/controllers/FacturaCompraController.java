package com.currantes.facturasTODO.controllers;

import com.currantes.facturasTODO.entities_model.Factura;
import com.currantes.facturasTODO.entities_model.FacturaCompra;
import com.currantes.facturasTODO.service.FacturaCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FacturaCompra")
public class FacturaCompraController {

    @Autowired
    FacturaCompraService facturaCompraService;

    @GetMapping("/buscarPorId/{id}")
    public FacturaCompra obtenerFacturaCompraPorId(@PathVariable Long id){
        return facturaCompraService.obtenerFacturaCompraPorId(id);
    }


    @GetMapping("/todaFacturas")
    public List<FacturaCompra> listarTodasFacturasCompra(){
       return facturaCompraService.listarTodasFacturasCompra();
    }

    @PostMapping("/crear")
    public void saveFacturaCompra( @RequestBody FacturaCompra facturaCompra){
        facturaCompraService.saveFacturaCompra(facturaCompra);
    }

    @PostMapping("/modificar")
    public void modificarFacturaCompra(@RequestBody FacturaCompra facturaCompra){
        facturaCompraService.modificarFacturaCompra(facturaCompra);
    }

    @DeleteMapping("/eliminar")
    public  void elimnarFacturaCompra(@PathVariable Long id){
        facturaCompraService.eliminarFacturaCompra(id);
    }





}
