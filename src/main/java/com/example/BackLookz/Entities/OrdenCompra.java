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

    @ManyToOne
    @NotNull(message = "La orden debe estar relacionada a un usuario")
    @JoinColumn(name = "usuario_id")
    private Usuario  usuario;

    private Double total;

    private Double descuento;

    @Column(name = "fecha_compra")
    private LocalDate fechaCompra;

    @ManyToOne
    @JoinColumn(name = "direccion_envio_id")
    private Direccion  direccionEnvio;

}
