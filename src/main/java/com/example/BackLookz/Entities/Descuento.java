package com.example.BackLookz.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="descuentos")
public class Descuento extends Base {

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    //falta relacion con precios
}