package com.currantes.facturasTODO.controllers;


import com.currantes.facturasTODO.entities_model.Logeo.LoginDto;
import com.currantes.facturasTODO.entities_model.Logeo.RegistrationDto;
import com.currantes.facturasTODO.service.seguridad.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.currantes.facturasTODO.entities_model.User;

import java.util.List;


@RequestMapping("/user")
@CrossOrigin(origins = "*") // permite recibir peticiones desde cualquier origen
@RestController
public class UserController {

// que no devuelva todos los campos, solo los que necesitamos (nombre contraseña...)
    @Autowired
    AuthenticationService auService;


    @PostMapping(value = "/register", consumes= MediaType.APPLICATION_JSON_VALUE)
    public User registrarUsuario(@RequestBody RegistrationDto body) {
        return auService.registrarUsuario(body.getUsername(), body.getLastname(), body.getDni(), body.getPassword(), body.getPhone(), body.getAddress());
    }
    @PostMapping(value = "/login", consumes=MediaType.APPLICATION_JSON_VALUE)
    public LoginDto iniciarUsuario(@RequestBody RegistrationDto body) {
        return auService.loginUsuario(body.getUsername(), body.getPassword());
        //quiero que devuelva
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> listarUsuarios() {
        return auService.listarUsuarios();
    }
}


