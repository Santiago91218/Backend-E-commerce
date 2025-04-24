package com.example.BackLookz.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="precios")
public class Precio extends Base {
    private float precio_compra;
    private float precio_venta;

    // falta relacion con detalle y descuento
}