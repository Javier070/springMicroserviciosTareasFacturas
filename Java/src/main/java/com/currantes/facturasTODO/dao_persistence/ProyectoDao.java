package com.currantes.facturasTODO.dao_persistence;

import com.currantes.facturasTODO.entities_model.Proyecto;
import com.currantes.facturasTODO.entities_model.Tarea;

import java.util.List;

public interface ProyectoDao {


    List<Proyecto>listaTodoProyectos();
    Proyecto DevolverProyectoUsandoID(long id);
    void salva(Proyecto proyecto);
    void  eliminaPorID(long id);
    void modificar(Proyecto proyecto);





}
