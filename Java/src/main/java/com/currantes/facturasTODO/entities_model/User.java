package com.currantes.facturasTODO.entities_model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column (nullable = false)
    private String username;

    @Column (nullable = false)
    private  String password;

    @Column (nullable = true)
    private String phone;

    @Column (nullable = true)
    private  String address;


////////////////// relación con la tabla roles
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="role_has_user",
            joinColumns = {@JoinColumn(name="user_iduser")},
            inverseJoinColumns = {@JoinColumn(name="role_idrole")}
    )
    private Set<Role> roles;
    ///////////////////////////////////////////////////
















    public User() {
        super();
        roles = new HashSet<>();
    }

    public User(Long idUser, String username, String password, Set<Role> roles) {
        super();
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }










    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Role role) {
        this.roles.add(role);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return this.roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}
