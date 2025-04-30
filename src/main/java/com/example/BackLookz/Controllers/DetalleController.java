package com.example.BackLookz.Controllers;

import com.example.BackLookz.Entities.Detalle;
import com.example.BackLookz.Repositories.DetalleRepository;
import com.example.BackLookz.Services.DetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detalles")
public class DetalleController extends BaseController<Detalle, Long, DetalleRepository, DetalleService> {

    public DetalleController(DetalleService service) {
        super(service);
    }

    @PutMapping("/agregar-stock/{idDetalle}")
    public ResponseEntity<String> agregarStock(@PathVariable Long idDetalle,@RequestParam int cantidadStock){
        try {
            service.agregarStock(idDetalle,cantidadStock);
            return ResponseEntity.ok("Stock agregado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al agregar stock: " + e.getMessage());
        }
    }


}
