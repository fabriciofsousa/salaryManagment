package com.ada.salaryManagment.service.impl;

import com.ada.salaryManagment.dto.UserDetailsInfo;
import com.ada.salaryManagment.model.Usuario;
import com.ada.salaryManagment.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UsuarioRepository repository;

    public UserDetailServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> optionalUser = repository.findByEmail(username);
        return new UserDetailsInfo(optionalUser.orElseThrow(() -> new UsernameNotFoundException("O usuário não foi encontrado!!!")));
    }
}
