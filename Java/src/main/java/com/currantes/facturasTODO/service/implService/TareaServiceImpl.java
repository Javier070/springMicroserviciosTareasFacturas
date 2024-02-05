package com.currantes.facturasTODO.service.implService;

import com.currantes.facturasTODO.dao_persistence.ProyectoDao;
import com.currantes.facturasTODO.dao_persistence.TareaDao;
import com.currantes.facturasTODO.entities_model.Proyecto;
import com.currantes.facturasTODO.entities_model.Tarea;
import com.currantes.facturasTODO.repository.TareaRepository;
import com.currantes.facturasTODO.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//TODA LA LÓGICA AQUI


@Service
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaDao tareaDao;

    @Autowired
    private ProyectoDao proyectoDao;
    @Override
    public List<Tarea> listaTodoTareas() {
        return tareaDao.listaTodoTareas();
    }

    @Override
    public Optional<Tarea> buscaPorIdTareas(long id) {
        return tareaDao.buscaPorIdTareas(id);
    }

    @Override
    public void eliminaPorIdTareas(long id) {
        tareaDao.eliminaPorIdTareas(id);

    }

    @Override
    public void salvaTareas(Tarea tarea) {
        tareaDao.salvaTareas(tarea);

    }
}
