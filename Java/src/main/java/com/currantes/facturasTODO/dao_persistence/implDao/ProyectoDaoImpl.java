package com.currantes.facturasTODO.dao_persistence.implDao;

import com.currantes.facturasTODO.dao_persistence.ProyectoDao;
import com.currantes.facturasTODO.entities_model.Proyecto;
import com.currantes.facturasTODO.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Repository
public class ProyectoDaoImpl implements ProyectoDao {// poder implementar lo métodos creados por nosotros
    //que seran sobreescritos usando la lógica de JPA

    @Autowired
    private ProyectoRepository proyectoRepository; //para poder acceder a los métodos de JPA

    @Override
    public List<Proyecto> listaTodoProyectos() {
        return proyectoRepository.findAll();
    }

    @Override
    public Optional<Proyecto> buscaPorId(long id) {
        return proyectoRepository.findById(id);
    }

    @Override
    public void salva(Proyecto proyecto) {
        proyectoRepository.save(proyecto);

    }

    @Override
    public void eliminaPorID(long id) {
        proyectoRepository.deleteById(id);


    }

    @Override
    public void modificar(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }
}
