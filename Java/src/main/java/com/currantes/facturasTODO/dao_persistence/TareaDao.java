package com.currantes.facturasTODO.dao_persistence;

import com.currantes.facturasTODO.entities_model.Tarea;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface   TareaDao {

    List<Tarea> listaTodoTareas();
    Optional<Tarea> buscaPorIdTareas(long id);
    void eliminaPorIdTareas(long id);
    void salvaTareas(Tarea tarea);
}
