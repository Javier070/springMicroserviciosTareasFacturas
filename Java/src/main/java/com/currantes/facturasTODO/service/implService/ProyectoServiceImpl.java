package com.currantes.facturasTODO.service.implService;

import com.currantes.facturasTODO.dao_persistence.ProyectoDao;
import com.currantes.facturasTODO.entities_model.Proyecto;
import com.currantes.facturasTODO.entities_model.Tarea;
import com.currantes.facturasTODO.entities_model.User;
import com.currantes.facturasTODO.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

//TODA LA LÓGICA AQUI, si se tienen que hacer implementaciones nuevas a los métodos ya existentes se hace aquí
@Service

public class ProyectoServiceImpl implements ProyectoService {


   @Autowired
   ProyectoDao proyectoDao; // gracias a esto puedo aaceder a los métodos del DAO
    @Override
    public List<Proyecto> listaTodoProyectos() {
        return proyectoDao.listaTodoProyectos();
    }

    @Override
    public Proyecto buscaPorId(long id) {
        return proyectoDao.DevolverProyectoUsandoID(id);
    }


    @Override
    public void salva(Proyecto proyecto) {
        if (proyectoDao.DevolverProyectoUsandoID(proyecto.getId()) == null) {
            proyectoDao.salva(proyecto);
            System.out.println("Se ha creado con éxito");
        } else {
            System.out.println("Error: El proyecto con el ID " + proyecto.getId() + " ya existe.");
        }
    }


    @Override
    public void eliminaPorID(long id) {
        proyectoDao.eliminaPorID(id);

    }

    @Override
    public void modificar(Proyecto proyecto) {
        if (proyectoDao.DevolverProyectoUsandoID(proyecto.getId())!= null){
            proyectoDao.modificar(proyecto);


        }

    }




    @Override
    public List<Tarea> TareasPorProyecto(Long id) {
        Proyecto proyecto = proyectoDao.DevolverProyectoUsandoID(id);
        if (proyecto != null) {
            return proyecto.getTareas();
        } else {
            return Collections.emptyList();
        }
    }

    }



//
//    @Override
//    public boolean proyectoFinalizado(Long idProyecto) {
//        // Aquí implementa la lógica para verificar si el proyecto está finalizado
//        // utilizando el DAO para obtener los datos necesarios de la base de datos.
//        return false; // Ejemplo: se devuelve false por defecto
//    }
//
//    @Override
//    public void actualizarEstadoProyecto(Long idProyecto, boolean estado) {
//        // Aquí implementa la lógica para actualizar el estado del proyecto
//        // utilizando el DAO para modificar los datos en la base de datos.
//        }
//
//
//}
