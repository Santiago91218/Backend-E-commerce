package com.example.BackLookz.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="direcciones")
public class Direccion extends Base{

    @NotNull(message = "La localidad no puede ser null")
    @NotBlank(message = "La localidad no puede estar vacio")
    private String localidad;

    @NotNull(message = "El pais no puede ser null")
    @NotBlank(message = "El pais no puede estar vacio")
    private String pais;

    @NotNull(message = "La provincia no puede ser null")
    @NotBlank(message = "La provincia no puede estar vacio")
    private String provincia;

    @NotNull(message = "El departamento no puede ser null")
    @NotBlank(message = "El departamento no puede estar vacio")
    private String departamento;

    @NotNull(message = "El codigoPostal no puede ser null")
    @NotBlank(message = "El codigoPostal no puede estar vacio")
    private String codigoPostal;


   @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuario_direccion",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "direccion_id")
    )
    private List<Usuario> usuarios = new ArrayList<>();

}
