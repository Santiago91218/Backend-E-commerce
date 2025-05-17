package com.example.BackLookz.Controllers;

import com.example.BackLookz.DTO.DetalleDTO;
import com.example.BackLookz.Entities.Detalle;
import com.example.BackLookz.Entities.enums.GeneroProducto;
import com.example.BackLookz.Entities.enums.TipoProducto;
import com.example.BackLookz.Repositories.DetalleRepository;
import com.example.BackLookz.Services.DetalleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @GetMapping("genero-producto")
    public ResponseEntity<?> filtrarPorSexo(@RequestParam GeneroProducto generoProducto){
        try{
            List<DetalleDTO> productos = service.filtrarPorSexo(generoProducto);
            return ResponseEntity.ok(productos);
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error al filtrar por sexo: "+e.getMessage());
        }
    }

    @GetMapping("relacionados")
    public ResponseEntity<?> filtrarProductosRelacionados(TipoProducto tipo, GeneroProducto genero,Long id) {
        try{
            List<DetalleDTO> productos = service.filtrarProductosRelacionados(tipo,genero,id);
            return ResponseEntity.ok(productos);
        }catch (Exception e){
            return  ResponseEntity.status(500).body("Error al filtrar por relacionados: "+e.getMessage());
        }
    }

    @GetMapping("/DTO/{id}")
    public ResponseEntity<?> obtenerDetallePorId(@PathVariable Long id) {
        try {
            DetalleDTO detalleDTO = service.obtenerDetalleDTO(id);
            return ResponseEntity.ok(detalleDTO);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener detalleDTO: " + e.getMessage());
        }
    }

    @GetMapping("/DTO")
    public ResponseEntity<?> obtenerTodosLosDetalles() {
        try {
            List<DetalleDTO> detalles = service.obtenerTodosLosDetalleDTO();
            return ResponseEntity.ok(detalles);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener los detalles: " + e.getMessage());
        }
    }


}
