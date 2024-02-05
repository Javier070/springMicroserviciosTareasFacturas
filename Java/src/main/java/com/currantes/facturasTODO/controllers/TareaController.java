package com.currantes.facturasTODO.controllers;

import com.currantes.facturasTODO.entities_model.Tarea;
import com.currantes.facturasTODO.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/tarea")
  public class TareaController  {

  @Autowired TareaService tareaService;

  @GetMapping("/tarea/todaTareas") List<Tarea> listaTodoTareas(){

   return tareaService.listaTodoTareas();
  }
}
