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
    public Proyecto buscaPorId(long id) {
        return proyectoDao.buscaPorId(id);
    }


    @Override
    public void salva(Proyecto proyecto) {
        if (proyectoDao.buscaPorId(proyecto.getId()) == null) {
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
        if (proyectoDao.buscaPorId(proyecto.getId())!= null){
            proyectoDao.modificar(proyecto);


        }

    }




    @Override
    public List<Tarea> TareasPorProyecto(Long id) {
        // Verifica si el Optional contiene un proyecto
        if (proyectoDao.buscaPorId(id) != null) {
            // Si se encuentra el proyecto, obtén sus tareas asociadas
            return proyectoDao.buscaPorId(id).getTareas();
        } else {
            // Si no se encuentra el proyecto, devuelve una lista vacía de tareas
            return Collections.emptyList();
        }
        //buscaPorId(id) de tu DAO (ProyectoDao) devuelve un objeto Optional<Proyecto>
        //Para obtener el objeto Proyecto contenido dentro de Optional, necesitas llamar al método get().

    }






    @Override
    public boolean proyectoFinalizado(Long idProyecto) {
        // Aquí implementa la lógica para verificar si el proyecto está finalizado
        // utilizando el DAO para obtener los datos necesarios de la base de datos.
        return false; // Ejemplo: se devuelve false por defecto
    }

    @Override
    public void actualizarEstadoProyecto(Long idProyecto, boolean estado) {
        // Aquí implementa la lógica para actualizar el estado del proyecto
        // utilizando el DAO para modificar los datos en la base de datos.
        }


}
