package com.currantes.facturasTODO.dao_persistence;

import java.util.Optional;

import com.currantes.facturasTODO.entities_model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaSpring extends JpaRepository<User, Integer>{

    Optional<User> findByUsername(String username);

}
