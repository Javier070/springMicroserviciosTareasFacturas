package com.currantes.facturasTODO.service.seguridad;

import com.currantes.facturasTODO.entities_model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    boolean guardarRole(Role role);
    List<Role> listarRoles();
    void modificarRole(Role role);
    boolean eliminarRole(int idRole);
    Role leerRole(int idRole);
    Optional<Role> findByAuthority(String authority);
}


