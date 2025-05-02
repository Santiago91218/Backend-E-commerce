package com.example.BackLookz.Entities;

import com.example.BackLookz.Entities.enums.GeneroProducto;
import com.example.BackLookz.Entities.enums.TipoProducto;
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
@Table(name="productos")
public class Producto extends Base {

    @NotNull(message = "Ingresa un nombre valido para el producto")
    @NotBlank(message = "Ingresa un nombre valido para el producto")
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_producto")
    @NotNull(message = "Ingresa un tipo producto valido para el producto")
    private TipoProducto tipoProducto;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Ingresa un sexo valido para el producto")
    @Column(name = "genero_producto")
    private GeneroProducto generoProducto;

    @ManyToOne
    @NotNull(message = "Ingresa una categoria para el producto")
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
