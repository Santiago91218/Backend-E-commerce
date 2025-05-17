package com.example.BackLookz.auth;

import com.example.BackLookz.Entities.Usuario;
import com.example.BackLookz.Entities.enums.TipoUsuario;
import com.example.BackLookz.Repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder; //ESTO LO AGREGO PARA HASHEAR LA CONTRASEÑA

    public AuthResponse login(LoginRequest request) {
        // Autenticamos con Spring Security
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getContrasenia())
        );

        // Buscamos el usuario en el repositorio por nombre (email)
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // Generamos el token JWT
        String jwtToken = jwtService.getToken(usuario);

        // Retornamos el token envuelto en la respuesta
        return new AuthResponse(jwtToken);
    }
    public AuthResponse register(RegisterRequest request) {
        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .email(request.getEmail())
                .contrasenia(passwordEncoder.encode(request.getContrasenia()))
                .rol(TipoUsuario.USER) // o ADMINISTRADOR / CLIENTE según el caso
                .dni(request.getDni())
                .build();
        usuarioRepository.save(usuario);

        String jwtToken = jwtService.getToken(usuario);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}

