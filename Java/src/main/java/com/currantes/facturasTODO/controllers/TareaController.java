package com.currantes.facturasTODO.controllers;

import com.currantes.facturasTODO.entities_model.Tarea;
import com.currantes.facturasTODO.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
@RequestMapping("/tarea")
  public class TareaController  {

  @Autowired TareaService tareaService;

  @GetMapping("/todaTareas") List<Tarea> listaTodoTareas(){
   return tareaService.listaTodoTareas();

//   @DeleteMapping("/eliminar/{id}")
//          public void eliminaPorIdTareas(@PathVariable Long id){
//              tareaService.eliminaPorIdTareas(id);
//
//      }




  }
}
