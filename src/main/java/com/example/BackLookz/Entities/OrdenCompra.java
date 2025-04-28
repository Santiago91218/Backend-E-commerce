package com.example.BackLookz.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ordenes_compra")
public class OrdenCompra extends Base {

    @NotNull(message = "La orden debe estar relacionada a un usuario")
    private Usuario  usuario;

    private Double total;

    private Double descuento;

    private LocalDate fechaCompra;

    private Direccion  direccionEnvio;

}
