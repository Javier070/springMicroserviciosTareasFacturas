package com.currantes.facturasTODO.dao_persistence;

import com.currantes.facturasTODO.entities_model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleJpaSpring extends JpaRepository<Role, Integer> {
    Optional<Role> findByAuthority(String authority);

}
