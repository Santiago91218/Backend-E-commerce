package com.example.BackLookz.Controllers;

import com.example.BackLookz.DTO.PagoRequest;
import com.example.BackLookz.Services.MercadoPagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/mercadopago")
public class MercadoPagoController {

    private final MercadoPagoService mercadoPagoService;

    public MercadoPagoController(MercadoPagoService mercadoPagoService) {
        this.mercadoPagoService = mercadoPagoService;
    }

    @PostMapping("/crear-preferencia")
    public ResponseEntity<?> crearPreferencia(@RequestBody PagoRequest request) {
        String initPoint = mercadoPagoService.crearPreferencia(request.getItems(), request.getEmail());

        if (initPoint == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "No se pudo generar la preferencia"));
        }

        return ResponseEntity.ok(Map.of("init_point", initPoint));
    }

}
