package com.example.BackLookz.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="detalles")
@NoArgsConstructor
@AllArgsConstructor
public class Detalle extends Base {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "talle_id")
    private Talle talle;

    @Column(name = "stock")
    private Number stock;

    @Column(name = "FK_products")
    private Long FK_products;

    @Column(name = "color")
    private String color;

    @Column(name = "estado")
    private String estado;
}
