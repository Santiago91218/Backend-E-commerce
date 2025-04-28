package com.example.BackLookz.Entities;

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

    @Column(length = 700)
    @NotNull(message = "Ingresa una url valida de la imagen")
    @NotBlank(message = "Ingresa una url valida de la imagen")
    private String url;

    @Column(length = 100)
    private String alt;

    @ManyToOne
    @NotNull(message = "Ingresa un detalle valido para la imagen")
    @JoinColumn(name = "detalle_id")
    private Detalle detalle;

}