package com.example.BackLookz.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="detalles")
@NoArgsConstructor
@AllArgsConstructor
public class Detalle extends Base {

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message = "Ingresa un talle valido")
    @JoinColumn(name = "talle_id")
    private Talle talle;

    private int stock;

    @Column(name = "producto_id")
    private Producto producto;

    private String color;

    private boolean estado;

    @OneToMany(mappedBy = "detalle", orphanRemoval = true)
    private List<Imagen> imagenes = new ArrayList<>();

}
