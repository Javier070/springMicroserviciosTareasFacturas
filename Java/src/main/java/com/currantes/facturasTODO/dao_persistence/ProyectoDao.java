package com.currantes.facturasTODO.dao_persistence;

import com.currantes.facturasTODO.entities_model.Proyecto;

import java.util.List;
import java.util.Optional;

public interface ProyectoDao {


    List<Proyecto>listaTodoProyectos();
    Optional<Proyecto> buscaPorId(long id); //pongo optional para  manejar resultados que pueden ser nulos
    void salva(Proyecto proyecto);
    void  eliminaPorID(long id);
}
