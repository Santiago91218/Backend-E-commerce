package com.example.BackLookz.Controllers;

import com.example.BackLookz.DTO.DireccionDTO;
import com.example.BackLookz.Entities.Direccion;
import com.example.BackLookz.Repositories.DireccionRepository;
import com.example.BackLookz.Services.DireccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    private final DireccionService service;

    public DireccionController(DireccionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DireccionDTO> crearDireccion(@RequestBody Direccion direccion) throws Exception {
        DireccionDTO dto = service.crearYRetornarDTO(direccion);
        return ResponseEntity.ok(dto);
    }
}

