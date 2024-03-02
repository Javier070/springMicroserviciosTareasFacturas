package com.currantes.facturasTODO.controllers;

import com.currantes.facturasTODO.entities_model.Tarea;
import com.currantes.facturasTODO.entities_model.User;
import com.currantes.facturasTODO.repository.ProyectoRepository;
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

   @Autowired
   private ProyectoRepository proyectoRepository;

   @GetMapping(value = "/{id}/tareas")
   public List<Tarea> TareasPorProyecto(@PathVariable Long id) {
      return proyectoService.TareasPorProyecto(id);
   }

   @GetMapping("/proyectosPorUsuario/{id}")
   public List<Proyecto> obtenerProyectosPorUsuario(@PathVariable Long id) {
      User user = new User();
      user.setIdUser(id);
      return proyectoRepository.findProyectosByUser(user);
   }

   ///////////////////////////////////////////////////////////

   @GetMapping(value = "/listaProyectos")
   public List<Proyecto> listaTodoProyectos() {
      return proyectoService.listaTodoProyectos();
   }

   @GetMapping(value = "/buscar/{id}")
   public Proyecto buscarPorId(@PathVariable Long id) {
      return proyectoService.buscaPorId(id);
   }


   @PostMapping(value = "/crear")
   public void guardarProyecto(@RequestBody Proyecto proyecto) {
      proyectoService.salva(proyecto);
   }

   @PostMapping(value = "/modificar")
   public void modificarProyecto(@RequestBody Proyecto proyecto) {
      proyectoService.modificar(proyecto);
   }

   @DeleteMapping(value = "/eliminar/{id}")
   public void eliminaPorID(@PathVariable Long id) {
      proyectoService.eliminaPorID(id);
   }

   /////////////////////////////////////


}
