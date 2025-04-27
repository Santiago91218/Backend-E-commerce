package com.example.BackLookz.Entities;

import com.example.BackLookz.Entities.enums.TipoProducto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="productos")
public class Producto extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Enumerated
    @Column(name = "tipo_producto")
    private TipoProducto tipoProducto;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "id_categoria")
    private Long idCategoria;
}
