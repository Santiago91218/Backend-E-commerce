package com.example.BackLookz.Entities;

import com.example.BackLookz.Entities.enums.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name= "usuarios")
public class Usuario extends Base implements UserDetails {

    private String nombre;

    @Column(name = "contrasenia")
    private String contrasenia;

    @Enumerated(EnumType.STRING)
    private TipoUsuario rol;

    private String email;

    @Min(1000000)
    @Max(99999999)
    @NotNull(message = "El D.N.I no puede ser null")
    private int dni;

    @ManyToMany(mappedBy = "usuarios")
    private List<Direccion> direcciones = new ArrayList<>();

    // MÉTODOS DE SPRING SECURITY

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rol.name()));
    }

    @Override
    public String getPassword() {
        return contrasenia;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
