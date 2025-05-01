package com.example.BackLookz.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToOne
    @NotNull(message = "Ingresa un talle valido")
    @JoinColumn(name = "talle_id")
    private Talle talle;

    private int stock;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private String color;

    private boolean estado;

    @OneToOne
    @JoinColumn(name = "precio_id")
    @JsonIgnore
    private Precio precio;

    @OneToMany(mappedBy = "detalle", orphanRemoval = true)
    @JsonManagedReference
    private List<Imagen> imagenes = new ArrayList<>();

    private String descripcion;

}
