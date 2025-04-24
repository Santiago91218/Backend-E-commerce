package com.example.BackLookz.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ordenes_compra_detalle")
public class OrdenCompraDetalle extends Base {

    @ManyToOne
    @JoinColumn(name = "id_orden_compra", nullable = false)
    private OrdenCompra ordenCompra;

    @NotNull(message = "El ID del producto no puede ser null")
    private Long idProducto;

    @NotNull(message = "La cantidad no puede ser null")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Integer cantidad;
}