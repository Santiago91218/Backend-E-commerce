package com.example.BackLookz.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "direcciones")
public class Direccion extends Base {

    @NotNull(message = "La calle no puede ser null")
    @NotBlank(message = "La calle no puede estar vacía")
    private String calle;

    @NotNull(message = "El número no puede ser null")
    @NotBlank(message = "El número no puede estar vacío")
    private String numero;

    @NotNull(message = "La localidad no puede ser null")
    @NotBlank(message = "La localidad no puede estar vacía")
    private String localidad;

    @NotNull(message = "El país no puede ser null")
    @NotBlank(message = "El país no puede estar vacío")
    private String pais;

    @NotNull(message = "La provincia no puede ser null")
    @NotBlank(message = "La provincia no puede estar vacía")
    private String provincia;

    @NotNull(message = "El departamento no puede ser null")
    @NotBlank(message = "El departamento no puede estar vacío")
    private String departamento;

    @NotNull(message = "El código postal no puede ser null")
    @NotBlank(message = "El código postal no puede estar vacío")
    @Column(name = "codigo_postal")
    private String codigoPostal;

    @ManyToMany(mappedBy = "direcciones")
    @JsonIgnore
    private List<Usuario> usuarios = new ArrayList<>();

    @Transient
    private Usuario usuario;
}
