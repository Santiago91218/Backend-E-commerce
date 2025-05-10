package com.example.BackLookz.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="imagenes")
public class Imagen extends Base {

    @NotNull(message = "Ingresa una url valida de la imagen")
    @NotBlank(message = "Ingresa una url valida de la imagen")
    private String url;

    private String alt;

    @ManyToOne
    @NotNull(message = "Ingresa un detalle valido para la imagen")
    @JoinColumn(name = "detalle_id")
    @JsonBackReference
    private Detalle detalle;

}