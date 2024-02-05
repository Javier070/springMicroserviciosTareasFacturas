package com.currantes.facturasTODO.service;

import com.currantes.facturasTODO.entities_model.Proyecto;
import com.currantes.facturasTODO.entities_model.Tarea;

import java.util.List;
import java.util.Optional;

public interface ProyectoService {

    List<Proyecto> listaTodoProyectos();
    Optional<Proyecto>  buscaPorId(long id);
    void salva(Proyecto proyecto);
    void  eliminaPorID(long id);

    boolean modificar(Proyecto proyecto);

    List<Tarea> TareasPorProyecto(Long id);
}

