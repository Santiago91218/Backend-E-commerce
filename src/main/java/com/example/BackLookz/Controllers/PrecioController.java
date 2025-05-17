package com.example.BackLookz.Controllers;

import com.example.BackLookz.DTO.PrecioDTO;
import com.example.BackLookz.Entities.Precio;
import com.example.BackLookz.Repositories.PrecioRepository;
import com.example.BackLookz.Services.PrecioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/precios")
public class PrecioController extends BaseController<Precio, Long, PrecioRepository,PrecioService> {

    public PrecioController(PrecioService service) {
        super(service);
    }
    @GetMapping("/filtrar")
    public ResponseEntity<?> filtrarPorRangoDePrecio(@RequestParam Double min, @RequestParam Double max) {
        try {
            List<PrecioDTO> resultado = service.filtrarPorRangoDePrecio(min, max);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}