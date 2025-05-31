package com.example.BackLookz.DTO;

import com.example.BackLookz.Entities.enums.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String nombre;
    private String email;
    private TipoUsuario rol;

}