package com.currantes.facturasTODO.controllers;


import com.currantes.facturasTODO.entities_model.Logeo.LoginDto;
import com.currantes.facturasTODO.entities_model.Logeo.RegistrationDto;
import com.currantes.facturasTODO.service.seguridad.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.currantes.facturasTODO.entities_model.User;


@RequestMapping("/user")
@CrossOrigin(origins = "*") // permite recibir peticiones desde cualquier origen
@RestController
public class UserController {


    @Autowired
    AuthenticationService auService;


    @PostMapping(value = "/register", consumes= MediaType.APPLICATION_JSON_VALUE)
    public User registrarUsuario(@RequestBody RegistrationDto body) {
        return auService.registrarUsuario(body.getUsername(), body.getPassword());
    }
    @PostMapping(value = "/login", consumes=MediaType.APPLICATION_JSON_VALUE)
    public LoginDto iniciarUsuario(@RequestBody RegistrationDto body) {
        return auService.loginUsuario(body.getUsername(), body.getPassword());
    }
}


