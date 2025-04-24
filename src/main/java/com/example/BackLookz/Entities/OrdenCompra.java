package com.example.BackLookz.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ordenes_compra")
public class OrdenCompra extends Base {

    @NotNull(message = "El usuario no puede ser null")
    private String usuario;

    @NotNull(message = "El total no puede ser null")
    @PositiveOrZero(message = "El total no puede ser negativo")
    private Double total;

    @PositiveOrZero(message = "El descuento no puede ser negativo")
    private Double descuento;

    @NotBlank(message = "La fecha de compra no puede estar vacía")
    private String fechaCompra;

    @NotBlank(message = "La dirección de envío no puede estar vacía")
    private String direccionEnvio;

    @OneToMany(mappedBy = "ordenCompra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdenCompraDetalle> detalles = new ArrayList<>();
}
