package com.currantes.facturasTODO.controllers;

import com.currantes.facturasTODO.entities_model.Tarea;
import com.currantes.facturasTODO.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.currantes.facturasTODO.entities_model.Proyecto;

import java.util.List;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

   @Autowired
   private ProyectoService proyectoService;

   @GetMapping(value = "/{id}/tareas", produces = "application/json")
   public List<Tarea> TareasPorProyecto(@PathVariable Long id) {
      return proyectoService.TareasPorProyecto(id);
   }

   @GetMapping(value = "/listaProyectos", produces = "application/json")
   public List<Proyecto> listaTodoProyectos() {
      return proyectoService.listaTodoProyectos();
   }

   @GetMapping(value = "/buscar/{id}", produces = "application/json")
   public Proyecto buscarPorId(@PathVariable Long id) {
      return proyectoService.buscaPorId(id);
   }

   @PostMapping(value = "/crear", consumes = "application/json")
   public void guardarProyecto(@RequestBody Proyecto proyecto) {
      proyectoService.salva(proyecto);
   }

   @PostMapping(value = "/modificar", consumes = "application/json")
   public void modificarProyecto(@RequestBody Proyecto proyecto) {
      proyectoService.modificar(proyecto);
   }

   @DeleteMapping(value = "/eliminar/{id}")
   public void eliminaPorID(@PathVariable Long id) {
      proyectoService.eliminaPorID(id);
   }
}
