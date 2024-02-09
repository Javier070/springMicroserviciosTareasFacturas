package service;

import java.util.Optional;

import com.currantes.facturasTODO.dao_persistence.RoleJpaSpring;
import com.currantes.facturasTODO.entities_model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
//@Transactional

public class RoleServiceImpl {

    @Autowired
    RoleJpaSpring dao;



    public Optional<Role> findByAuthority(String authority) {
        // TODO Auto-generated method stub
        return dao.findByAuthority(authority);
    }
}
