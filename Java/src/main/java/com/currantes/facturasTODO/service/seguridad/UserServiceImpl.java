package com.currantes.facturasTODO.service.seguridad;

import java.util.Optional;

import com.currantes.facturasTODO.dao_persistence.UserJpaSpring;
import com.currantes.facturasTODO.entities_model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
//@Transactional
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    UserJpaSpring dao;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return dao.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user is not valid"));
    }

    public Optional<User> findByUsername(String username) {
        // TODO Auto-generated method stub
        return dao.findByUsername(username);
    }


}