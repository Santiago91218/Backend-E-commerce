package com.example.BackLookz.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
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

}
