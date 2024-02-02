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
    public Optional<Tarea> buscaPorId(long id) {
        return tareaRepository.findById(id);
    }

    @Override
    public void eliminaPorId(long id) {
        tareaRepository.deleteById(id);

    }

    @Override
    public void salva(Tarea tarea) {
        tareaRepository.save(tarea);

    }
}

