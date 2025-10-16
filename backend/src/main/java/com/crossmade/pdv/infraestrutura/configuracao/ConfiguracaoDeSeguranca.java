package com.crossmade.pdv.infraestrutura.configuracao;

import com.crossmade.pdv.aplicacao.usuario.servicos.AutenticacaoService;
import com.crossmade.pdv.aplicacao.usuario.servicos.JwtFiltroDeAutenticacao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
//@EnableWebSecurity
public class ConfiguracaoDeSeguranca {

    private final JwtFiltroDeAutenticacao jwtAuthFilter;
    private final AutenticacaoService usuarioDetailsService;

    public ConfiguracaoDeSeguranca(JwtFiltroDeAutenticacao jwtAuthFilter, AutenticacaoService usuarioDetailsService) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.usuarioDetailsService = usuarioDetailsService;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(usuarioDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder()); // 🔑 essencial
        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/usuarios/cadastrar").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.POST, "/api/produtos/**").hasAnyRole("ADMIN", "GERENTE")
                        .requestMatchers(HttpMethod.PUT, "/api/produtos/**").hasAnyRole("ADMIN", "GERENTE")
                        .requestMatchers(HttpMethod.POST, "/api/pedidos/**").hasAnyRole("ADMIN", "GERENTE")
                        .requestMatchers(HttpMethod.POST, "/api/orcamentos/**").hasAnyRole("ADMIN", "GERENTE")
                        .requestMatchers(HttpMethod.POST, "/api/clientes/**").hasAnyRole("ADMIN", "GERENTE")
                        .requestMatchers(HttpMethod.POST, "/api/categorias/**").hasAnyRole("ADMIN", "GERENTE")
                        .requestMatchers(HttpMethod.PUT, "/api/categorias/**").hasAnyRole("ADMIN", "GERENTE")
                        .requestMatchers(HttpMethod.POST, "/api/fornecedores/**").hasAnyRole("ADMIN", "GERENTE")
                        .requestMatchers(HttpMethod.PUT, "/api/fornecedores/**").hasAnyRole("ADMIN", "GERENTE")
                        .requestMatchers(HttpMethod.GET, "/api/fornecedores/**").hasAnyRole("ADMIN", "GERENTE")
                        .requestMatchers(HttpMethod.GET, "/api/produtos/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/categorias/**").authenticated()
                        .requestMatchers("/api/auth/**").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:4200")); // onde o Angular roda
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        config.setExposedHeaders(List.of("Authorization"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
