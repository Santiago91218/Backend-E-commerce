package com.example.BackLookz.DTO;

import com.example.BackLookz.Entities.Imagen;
import com.example.BackLookz.Entities.Precio;
import com.example.BackLookz.Entities.Producto;
import com.example.BackLookz.Entities.Talle;
import lombok.Data;

@Data
public class DetalleDTO {
    private Long id;
    private boolean disponible;
    private String color;
    private Producto producto;
    private Precio precio;
    private Imagen imagenPrincipal;
    private Talle talle;

}
