package com.currantes.facturasTODO.entities_model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Setter
@Entity
@JsonIgnoreProperties({"proyectos", // ya no se ven los proyectos que tiene asociado un user
        "facturasCompra","facturasVenta", // asi esta bien escrito
        "authorities", "roles","credentialsNonExpired","accountNonExpired","accountNonLocked","enabled"}) //con esto solo se muestran


public class User implements UserDetails {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idUser;

    @Column (nullable = false)
    private String username;

    @Column (nullable = false)
    private String firstName;

    @Column (nullable = false)
    private String lastName;

    @Column (nullable = false)
    private String dni;

    @Column (nullable = false)
    private  String password;

    @Column (nullable = true)
    private String phone;

    @Column (nullable = false)
    private String email;

    @Column (nullable = true)
    private  String address;


////////////////// relación con la tabla roles
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="role_has_user", joinColumns = {@JoinColumn(name="user_iduser")}, inverseJoinColumns = {@JoinColumn(name="role_idrole")})
    private Set<Role> roles;

    ///////////////////////////////////////////////////

/////////////////////////////// relación con tabla Proyectos
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Proyecto> proyectos;
    /////////////////

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
   private List<FacturaVenta> facturasVenta; // Corregido


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<FacturaCompra> facturasCompra;







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


    public User(Long idUser, String username, String password, String phone, String address, Set<Role> roles) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.roles = roles;

    }

    public User(Long idUser, String username,String firstName,  String lastName, String dni, String password,String email, String phone, String address, Set<Role> roles) {
        this.idUser = idUser;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.address = address;
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
