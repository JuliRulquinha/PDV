package com.crossmade.pdv.api.usuario.auth;

import com.crossmade.pdv.aplicacao.usuario.servicos.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping("api/auth")
public class AutorizacaoEndpoint {

    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    public AutorizacaoEndpoint(JwtService jwtService, AuthenticationManager authManager) {
        this.jwtService = jwtService;
        this.authManager = authManager;
    }

    @PostMapping("login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(body.get("nome"), body.get("senha"))
            );

            String token = jwtService.gerarToken(Map.of(), body.get("nome"));
            return Map.of("token", token);
        } catch (AuthenticationException e) {
            throw new RuntimeException("Credenciais inválidas");
        }
    }
}
