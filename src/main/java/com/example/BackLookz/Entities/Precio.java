package com.example.BackLookz.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="precios")
public class Precio extends Base {

    @NotNull(message = "Ingresa un precio compra del producto")
    private Double precio_compra;

    @NotNull(message = "Ingresa un precio venta del producto")
    private Double precio_venta;

    @ManyToOne
    @JoinColumn(name = "descuento_id")
    private Descuento descuento;

    @NotNull(message = "Ingresa un detalle")
    private Detalle detalle;

}