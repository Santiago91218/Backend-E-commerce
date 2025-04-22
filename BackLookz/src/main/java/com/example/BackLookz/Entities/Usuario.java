package com.example.BackLookz.Entities;

import com.example.BackLookz.Entities.enums.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name= "usuarios")
public class Usuario extends Base{

    @NotNull(message = "El nombre no puede ser null")
    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    @NotNull(message = "La contraseña no puede ser null")
    @NotBlank(message = "La contraseña no puede estar vacia")
    private String contrasenia;

    @Enumerated(EnumType.STRING)
    private TipoUsuario rol;

    @Email(message = "El email debe ser valido")
    private String email;

    @Min(10000000)
    @Max(99999999)
    @NotNull(message = "El D.N.I no puede ser null")
    private int dni;

    @ManyToMany
    @JoinTable(name = "usuarios_direcciones",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_direccion"))
    private List<Direccion> direcciones = new ArrayList<>();

}
