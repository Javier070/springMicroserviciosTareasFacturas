package com.currantes.facturasTODO.service.implService;

import com.currantes.facturasTODO.dao_persistence.ProyectoDao;
import com.currantes.facturasTODO.entities_model.Proyecto;
import com.currantes.facturasTODO.entities_model.Tarea;
import com.currantes.facturasTODO.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
        if (proyectoDao.buscaPorId(proyecto.getId())==null){
            proyectoDao.modificar(proyecto);

        }
    }

    @Override
    public void eliminaPorID(long id) {
        proyectoDao.eliminaPorID(id);

    }

    @Override
    public boolean modificar(Proyecto proyecto) {
        if (proyectoDao.buscaPorId(proyecto.getId())!=null){
            proyectoDao.modificar(proyecto);
            return true;

        }
        return  false;
    }




    @Override
    public List<Tarea> TareasPorProyecto(Long id) {
        // Busca el proyecto por su ID
        Optional<Proyecto> proyectoOptional = proyectoDao.buscaPorId(id);

        if (proyectoOptional.isPresent()) {
            // Si se encuentra el proyecto, obtén sus tareas asociadas
            Proyecto proyecto = proyectoOptional.get();
            return proyecto.getTareas();
        } else {
            // Si no se encuentra el proyecto, devuelve una lista vacía de tareas
            return Collections.emptyList();
        }

    }
}
