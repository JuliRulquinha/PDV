package com.crossmade.pdv.api.usuario.auth;

import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossmade.pdv.aplicacao.usuario.servicos.AutenticacaoService;
import com.crossmade.pdv.aplicacao.usuario.servicos.JwtService;

@RestController
@RequestMapping("api/auth")
public class AutorizacaoEndpoint {

    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    private final AutenticacaoService userDetailsService;

    public AutorizacaoEndpoint(JwtService jwtService, AuthenticationManager authManager, com.crossmade.pdv.aplicacao.usuario.servicos.AutenticacaoService userDetailsService) {
        this.jwtService = jwtService;
        this.authManager = authManager;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(body.get("nome"), body.get("senha"))
            );


            var userDetails = (UserDetails) userDetailsService.loadUserByUsername(body.get("nome"));

            String papel = userDetails.getAuthorities()
                .stream()
                .findFirst()
                .map(a -> a.getAuthority())
                .orElse("USER");

            String token = jwtService.gerarToken(Map.of(), body.get("nome"), papel);
            return Map.of("token", token);
        } catch (AuthenticationException e) {
            throw new RuntimeException("Credenciais inválidas");
        }
    }
}
