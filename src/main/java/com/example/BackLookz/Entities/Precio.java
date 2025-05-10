package com.example.BackLookz.Entities;

import jakarta.persistence.*;
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
    @Column(name = "precio_compra")
    private Double precioCompra;

    @NotNull(message = "Ingresa un precio venta del producto")
    @Column(name = "precio_venta")
    private Double precioVenta;

    @ManyToOne
    @JoinColumn(name = "descuento_id")
    private Descuento descuento;

}