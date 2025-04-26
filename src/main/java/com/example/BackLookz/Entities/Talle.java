package com.example.BackLookz.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="talles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Talle extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El campo talle no puede ser null")
    @NotBlank(message = "El campo talle no puede estar vacio")
    private String talle;
}
