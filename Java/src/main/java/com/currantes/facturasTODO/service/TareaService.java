package com.currantes.facturasTODO.service;

import com.currantes.facturasTODO.entities_model.Tarea;

import java.util.List;
import java.util.Optional;

public interface TareaService {

    List<Tarea> listaTodoTareas();
    Tarea buscaPorIdTareas(long id);
    void eliminaPorIdTareas(long id);
    void salvaTareas(Tarea tarea);

    void modificarTareas(Tarea tarea);


}
