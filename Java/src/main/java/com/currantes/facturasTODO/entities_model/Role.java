package com.currantes.facturasTODO.entities_model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Data
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    @Column(nullable = false)
    private String authority;
    public Role() {
        super();
    }

    public Role(Long idRole, String authority) {
        super();
        this.idRole = idRole;
        this.authority = authority;
    }


    public Role(String authority) {
        super();
        this.authority = authority;
    }

}
