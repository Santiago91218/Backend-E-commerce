package com.example.BackLookz.Controllers;

import com.example.BackLookz.Entities.OrdenCompra;
import com.example.BackLookz.Services.OrdenCompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes-compra")
public class OrdenCompraController {

    private final OrdenCompraService service;

    public OrdenCompraController(OrdenCompraService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> crearOrden(@RequestBody OrdenCompra orden) {
        try {
            OrdenCompra nuevaOrden = service.crear(orden);
            return ResponseEntity.ok("Orden creada con ID: " + nuevaOrden.getId());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al crear la orden");
        }
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<OrdenCompra>> obtenerOrdenesProUsuario(@PathVariable Long id) {
        try {
            List<OrdenCompra> ordenes = service.obtenerOrdenesPorUsuarioId(id);
            return ResponseEntity.ok(ordenes);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}

