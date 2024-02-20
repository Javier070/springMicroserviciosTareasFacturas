package com.currantes.facturasTODO.service.seguridad;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.currantes.facturasTODO.dao_persistence.RoleJpaSpring;
import com.currantes.facturasTODO.dao_persistence.UserJpaSpring;
import com.currantes.facturasTODO.entities_model.Logeo.LoginDto;
import com.currantes.facturasTODO.entities_model.Logeo.RegistrationDto;
import com.currantes.facturasTODO.entities_model.Role;
import com.currantes.facturasTODO.entities_model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
//@Transactional
public class AuthenticationService {

    @Autowired
    private UserJpaSpring userService;

    @Autowired
    RoleJpaSpring roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;


    public User registrarUsuario(RegistrationDto body) {
        // Verificar si el usuario ya existe en la base de datos
        User existingUser = userService.findUserByUsername(body.getUsername());
        if (existingUser != null) {
            // Si el usuario ya existe, devolver ese usuario
            return existingUser;
        } else {
            // Si el usuario no existe, proceder con el registro
            String encodedPassword = passwordEncoder.encode(body.getPassword());
            Role userRole = roleService.findByAuthority("USER").orElse(null);
            if (userRole == null) {
                // Manejar el caso donde no se encuentra el rol
                throw new IllegalStateException("No se encontró el rol 'USER'.");
            }
            Set<Role> authorities = new HashSet<>();
            authorities.add(userRole);
            User newUser = new User(0L, body.getUsername(), body.getFirstName(), body.getLastName(), body.getDni(), encodedPassword, body.getEmail(), body.getPhone(), body.getAddress(), authorities);
            return userService.save(newUser);
        }
    }

    public LoginDto loginUsuario(String username, String password) {

        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);

            return new LoginDto(userService.findByUsername(username).get(), token);

        } catch(AuthenticationException e){
            return new LoginDto(null, "");
        }


    }

    public List<User> listarUsuarios() {
        return userService.findAll();
    }
}
