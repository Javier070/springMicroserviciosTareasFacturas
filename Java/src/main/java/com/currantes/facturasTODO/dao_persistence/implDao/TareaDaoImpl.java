package com.currantes.facturasTODO.dao_persistence.implDao;

import com.currantes.facturasTODO.dao_persistence.TareaDao;
import com.currantes.facturasTODO.entities_model.Tarea;
import com.currantes.facturasTODO.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TareaDaoImpl implements TareaDao {
    @Autowired
    private TareaRepository tareaRepository;


    @Override
    public List<Tarea> listaTodoTareas() {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea buscaPorIdTareas(long id) {
        return tareaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminaPorIdTareas(long id) {
        tareaRepository.deleteById(id);

    }

    @Override
    public void salvaTareas(Tarea tarea) {
        tareaRepository.save(tarea);

    }


}

