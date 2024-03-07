package com.currantes.facturasTODO.service;

import com.currantes.facturasTODO.dao_persistence.CRUD;
import com.currantes.facturasTODO.entities_model.Proyecto;
import com.currantes.facturasTODO.entities_model.Tarea;

import java.util.List;
import java.util.Optional;

public interface ProyectoService  {
    List<Tarea> TareasPorProyecto(Long id);

    List<Proyecto> obtenerProyectosPorUsuario(Long id);



    List<Proyecto> listaTodoProyectos();
    Proyecto buscaPorId(long id);
    void salva(Proyecto proyecto);
    void  eliminaPorID(long id);

    void modificar(Proyecto proyecto);






    ///////
//    boolean proyectoFinalizado(Long idProyecto);
//    void actualizarEstadoProyecto(Long idProyecto, boolean estado);
    ///////
}

