package com.example.BackLookz.Controllers;

import com.example.BackLookz.Entities.OrdenCompra;
import com.example.BackLookz.Repositories.OrdenCompraRepository;
import com.example.BackLookz.Services.OrdenCompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ordenes-compra")
public class OrdenCompraController extends BaseController<OrdenCompra, Long, OrdenCompraRepository, OrdenCompraService> {

    public OrdenCompraController(OrdenCompraService service) {
        super(service);
    }


    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<OrdenCompra>> obtenerOrdenesProUsuari(@PathVariable Long id) {
        try {
            List<OrdenCompra> ordenes = service.obtenerOrdenesPorUsuarioId(id);
            return ResponseEntity.ok(ordenes);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
