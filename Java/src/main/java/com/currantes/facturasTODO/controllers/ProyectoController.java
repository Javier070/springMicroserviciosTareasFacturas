package com.currantes.facturasTODO.controllers;

import com.currantes.facturasTODO.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.currantes.facturasTODO.entities_model.Proyecto; // Asegúrate de importar la clase Proyecto aquí

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proyecto")
   public class ProyectoController { // soy clase

   @Autowired
   private ProyectoService proyectoService;

   @GetMapping("/listaProyectos")
   public List <Proyecto> listaTodoProyectos(){
      return proyectoService.listaTodoProyectos();

   }

   @DeleteMapping("/eliminar/{id}")
   public void eliminaPorID(@PathVariable Long id) {
      proyectoService.eliminaPorID(id);
   }


   @GetMapping("/buscar/{id}")
   public Proyecto buscarPorId(@PathVariable Long id) {
      Optional<Proyecto> proyectoOptional = proyectoService.buscaPorId(id);
      return proyectoOptional.orElse(null);

   }
      @PostMapping("/salvar")
      public void guardarProyecto(@RequestBody Proyecto proyecto) {
       proyectoService.salva(proyecto);
      }









   }




