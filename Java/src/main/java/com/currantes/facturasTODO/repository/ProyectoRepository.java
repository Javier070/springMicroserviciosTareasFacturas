package com.currantes.facturasTODO.repository;

import com.currantes.facturasTODO.entities_model.Proyecto;
import com.currantes.facturasTODO.entities_model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long>{

//    Proyecto DevolverProyectoUsandoID(long id);
    List<Proyecto> findProyectosByUser(User user);




}


