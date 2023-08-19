package com.ada.salaryManagment.service.security;

import com.ada.salaryManagment.dto.security.AuthRequestDTO;
import com.ada.salaryManagment.dto.security.AuthResponseDTO;
import com.ada.salaryManagment.exception.UsuarioNaoEncontradoException;
import com.ada.salaryManagment.model.Usuario;
import com.ada.salaryManagment.repository.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;

    private final AuthenticationManager authenticationManager;

    public AuthService(JwtService jwtService, UsuarioRepository usuarioRepository, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponseDTO authenticate(AuthRequestDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsuario(),
                request.getSenha()
        ));
        Usuario usuario = usuarioRepository.findByEmail(request.getUsuario()).orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado"));

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("nome", "Fabricio");

        String token = jwtService.generateToken(usuario, extraClaims);
        return new AuthResponseDTO(token);
    }
}
