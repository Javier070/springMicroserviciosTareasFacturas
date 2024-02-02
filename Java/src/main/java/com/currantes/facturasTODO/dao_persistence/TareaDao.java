package com.currantes.facturasTODO.dao_persistence;

import com.currantes.facturasTODO.entities_model.Tarea;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface   TareaDao {

    List<Tarea> listaTodoTareas();
    Optional<Tarea> buscaPorId(long id);
    void eliminaPorId(long id);
    void salva(Tarea tarea);
}
