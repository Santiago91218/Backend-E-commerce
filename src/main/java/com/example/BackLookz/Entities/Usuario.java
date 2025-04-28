package com.example.BackLookz.Entities;

import com.example.BackLookz.Entities.enums.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "usuarios")
public class Usuario extends Base{

    private String nombre;

    private String contrasenia;

    @Enumerated(EnumType.STRING)
    private TipoUsuario rol;

    private String email;

    @Min(10000000)
    @Max(99999999)
    @NotNull(message = "El D.N.I no puede ser null")
    private int dni;

    @ManyToMany(mappedBy = "usuarios")
    private ArrayList<Direccion> direcciones = new ArrayList<>();

}
