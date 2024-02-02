package com.currantes.facturasTODO.service.implService;

import com.currantes.facturasTODO.dao_persistence.ProyectoDao;
import com.currantes.facturasTODO.entities_model.Proyecto;
import com.currantes.facturasTODO.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//TODA LA LÓGICA AQUI, si se tienen que hacer implementaciones nuevas a los métodos ya existentes se hace aquí
@Service
public class ProyectoServiceImpl implements ProyectoService {


   @Autowired
   ProyectoDao proyectoDao; // llamamos al DAO
    @Override
    public List<Proyecto> listaTodoProyectos() {
        return proyectoDao.listaTodoProyectos();
    }

    @Override
    public Optional<Proyecto> buscaPorId(long id) {
        return proyectoDao.buscaPorId(id);
    }

    @Override
    public void salva(Proyecto proyecto) {
        proyectoDao.salva(proyecto);

    }

    @Override
    public void eliminaPorID(long id) {
        proyectoDao.eliminaPorID(id);

    }
}
