package com.example.BackLookz.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DireccionDTO {
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
    private String pais;
    private String codigoPostal;
    private boolean disponible;
    private String departamento;
    private UsuarioDTO usuario;
}
