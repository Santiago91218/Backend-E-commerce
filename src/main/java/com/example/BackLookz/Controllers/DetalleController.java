package com.example.BackLookz.Controllers;

import com.example.BackLookz.DTO.DetalleDTO;
import com.example.BackLookz.Entities.Detalle;
import com.example.BackLookz.Entities.Usuario;
import com.example.BackLookz.Entities.enums.GeneroProducto;
import com.example.BackLookz.Entities.enums.TipoProducto;
import com.example.BackLookz.Repositories.DetalleRepository;
import com.example.BackLookz.Services.DetalleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/detalles")
public class DetalleController extends BaseController<Detalle, Long, DetalleRepository, DetalleService> {

    public DetalleController(DetalleService service) {
        super(service);
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

    @GetMapping("/{productoId}/detalles")
    public ResponseEntity<?> obtenerDetallesPorProducto(@PathVariable Long productoId) {
        try {
            List<Detalle> detalles = service.obtenerDetallesPorProducto(productoId);
            return ResponseEntity.ok(detalles);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener detalles: " + e.getMessage());
        }
    }

    @GetMapping("/filtrar-por-precio")
    public ResponseEntity<?> filtrarPorRangoDePrecio(
            @RequestParam Double min,
            @RequestParam Double max) {
        try {
            List<DetalleDTO> resultado = service.filtrarPorRangoDePrecio(min, max);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
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

    @GetMapping("destacados")
    public ResponseEntity<?> getProductsDestacados() {
        try{
            List<DetalleDTO> productos = service.obtenerDetallesConDescuentoYDestacados();
            return ResponseEntity.ok(productos);
        }catch (Exception e){
            return  ResponseEntity.status(500).body("Error al obtenr destacados: "+e.getMessage());
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
