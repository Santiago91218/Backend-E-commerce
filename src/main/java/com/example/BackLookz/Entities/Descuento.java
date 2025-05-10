package com.example.BackLookz.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="descuentos")
public class Descuento extends Base {

    @NotNull(message = "Ingresa una fecha inicio del descuento")
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @NotNull(message = "Ingresa una fecha final del descuento")
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @NotNull(message = "Ingresa un porcentaje del descuento")
    private double descuento;

}