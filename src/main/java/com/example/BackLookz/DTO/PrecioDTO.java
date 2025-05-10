package com.example.BackLookz.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrecioDTO {
    private Double precioCompra;
    private Double precioVenta;
}