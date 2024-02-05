package com.currantes.facturasTODO.controllers;

import com.currantes.facturasTODO.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.currantes.facturasTODO.entities_model.Proyecto; // Asegúrate de importar la clase Proyecto aquí

import java.util.List;
import java.util.Optional;
//hola
@RestController
@RequestMapping("/proyecto")
   public class ProyectoController { // soy clase

   @Autowired
   private ProyectoService proyectoService;

   @GetMapping("/listaProyectos")
   public List <Proyecto> listaTodoProyectos(){
      return proyectoService.listaTodoProyectos();

   }



   @GetMapping("/buscar/{id}")
   public Proyecto buscarPorId(@PathVariable Long id) {
      Optional<Proyecto> proyectoOptional = proyectoService.buscaPorId(id);
      return proyectoOptional.orElse(null);

   }
      @PostMapping("/crear")
      public void guardarProyecto(@RequestBody Proyecto proyecto) {
       proyectoService.salva(proyecto);
      }
      // implica asociar el cuerpo de la solicitud HTTP con un objeto Java específico,
   // es decir, vincular los datos enviados en la solicitud con un objeto Java en la aplicación.

   @PostMapping("/modificar")
   public void modificarProyecto(@RequestBody Proyecto proyecto) {
      proyectoService.modificar(proyecto);
   }




   @DeleteMapping("/eliminar/{id}")
   public void eliminaPorID(@PathVariable Long id) {
      proyectoService.eliminaPorID(id);
   }







   }




