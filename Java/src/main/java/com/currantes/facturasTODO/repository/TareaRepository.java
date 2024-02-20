package com.currantes.facturasTODO.repository;

import com.currantes.facturasTODO.entities_model.Tarea;
import com.currantes.facturasTODO.entities_model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {

    //aqui vamos a crear nuestro métodos especiales usando @query
    //Esto es para métodos que no nos provea Jpa y tú debes de crearlos


}

