package com.example.BackLookz.config;

import com.example.BackLookz.auth.JWTAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;
import java.util.List;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JWTAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .cors(withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()

                        // Productos
                        .requestMatchers(HttpMethod.GET, "/productos/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/productos/**").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.PUT, "/productos/**").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.DELETE, "/productos/**").hasRole("ADMINISTRADOR")

                        // Categorías
                        .requestMatchers(HttpMethod.GET, "/categorias/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/categorias/**").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.PUT, "/categorias/**").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.DELETE, "/categorias/**").hasRole("ADMINISTRADOR")

                        // Descuentos
                        .requestMatchers(HttpMethod.GET, "/descuentos/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/descuentos/**").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.PUT, "/descuentos/**").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.DELETE, "/descuentos/**").hasRole("ADMINISTRADOR")

                        // Detalle
                        .requestMatchers(HttpMethod.GET, "/detalles/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/detalles/**").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.PUT, "/detalles/**").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.DELETE, "/detalles/**").hasRole("ADMINISTRADOR")


                        // Direcciones (CLIENTE puede ver/crear las suyas)
                        .requestMatchers(HttpMethod.GET, "/direcciones/**").hasAnyRole("CLIENTE","ADMINISTRADOR")
                        .requestMatchers(HttpMethod.POST, "/direcciones/**").hasAnyRole("CLIENTE","ADMINISTRADOR")
                        .requestMatchers(HttpMethod.PUT, "/direcciones/**").hasAnyRole("CLIENTE","ADMINISTRADOR")
                        .requestMatchers(HttpMethod.DELETE, "/direcciones/**").hasRole("CLIENTE")

                        // Imágenes
                        .requestMatchers(HttpMethod.GET, "/imagenes/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/imagenes/**").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.PUT, "/imagenes/**").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.DELETE, "/imagenes/**").hasRole("ADMINISTRADOR")

                        // OrdenCompra
                        .requestMatchers(HttpMethod.GET, "/ordenes-compra/**").hasAnyRole("CLIENTE", "ADMINISTRADOR")
                        .requestMatchers(HttpMethod.POST, "/ordenes-compra/**").hasAnyRole("CLIENTE", "ADMINISTRADOR")
                        .requestMatchers(HttpMethod.PUT, "/ordenes-compra/**").hasAnyRole("CLIENTE", "ADMINISTRADOR")
                        .requestMatchers(HttpMethod.DELETE, "/ordenes-compra/**").hasRole("CLIENTE")

                        // OrdenCompraDetalle
                        .requestMatchers(HttpMethod.GET, "/ordenes-compra-detalle/**").hasAnyRole("CLIENTE", "ADMINISTRADOR")
                        .requestMatchers(HttpMethod.POST, "/ordenes-compra-detalle/**").hasAnyRole("CLIENTE", "ADMINISTRADOR")
                        .requestMatchers(HttpMethod.PUT, "/ordenes-compra-detalle/**").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.DELETE, "/ordenes-compra-detalle/**").hasRole("ADMINISTRADOR")

                        // Precio
                        .requestMatchers(HttpMethod.GET, "/precios/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/precios/**").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.PUT, "/precios/**").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.DELETE, "/precios/**").hasRole("ADMINISTRADOR")

                        // Talle
                        .requestMatchers(HttpMethod.GET, "/talles/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/talles/**").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.PUT, "/talles/**").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.DELETE, "/talles/**").hasRole("ADMINISTRADOR")

                        // Usuario
                        .requestMatchers(HttpMethod.GET, "/usuarios/**").hasAnyRole("CLIENTE","ADMINISTRADOR")
                        .requestMatchers(HttpMethod.PUT, "/usuarios/**").hasAnyRole("CLIENTE","ADMINISTRADOR")
                        .requestMatchers(HttpMethod.DELETE, "/usuarios/**").hasAnyRole("CLIENTE","ADMINISTRADOR")
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOriginPatterns(List.of("http://localhost:5173"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
