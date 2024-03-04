package com.currantes.facturasTODO.controllers;

import com.currantes.facturasTODO.entities_model.FacturaCompra;
import com.currantes.facturasTODO.entities_model.User;
import com.currantes.facturasTODO.repository.FacturaCompraRepository;
import com.currantes.facturasTODO.repository.ProyectoRepository;
import com.currantes.facturasTODO.service.FacturaCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FacturaCompra")
public class FacturaCompraController {

    @Autowired
    FacturaCompraService facturaCompraService;

    @Autowired
    private FacturaCompraRepository facturaCompraRepository;



    @GetMapping("/cantidadFacturasPorUsuario/{id}")
    public List<FacturaCompra> obtenerCantidadFacturasCompraPorUsuario(@PathVariable Long id) {
        User user = new User();
        user.setIdUser(id);
        return facturaCompraRepository.findFacturaCompraByUser(user);
    }

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

    @DeleteMapping("/eliminar/{id}")
    public  void elimnarFacturaCompra(@PathVariable Long id){
        facturaCompraService.eliminarFacturaCompra(id);
    }





}
