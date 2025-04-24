package com.example.BackLookz.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="categorias")
public class Categoria extends Base{

    @NotNull(message = "El nombre no puede ser null")
    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    //falta relacion con producto

}