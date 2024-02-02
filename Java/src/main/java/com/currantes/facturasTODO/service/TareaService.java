package com.currantes.facturasTODO.service;

import com.currantes.facturasTODO.entities_model.Tarea;

import java.util.List;
import java.util.Optional;

public interface TareaService {

    List<Tarea> listaTodoTareas();
    Optional<Tarea> buscaPorId(long id);
    void eliminaPorId(long id);
    void salva(Tarea tarea);
}
