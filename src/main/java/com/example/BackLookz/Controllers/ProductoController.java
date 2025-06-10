package com.example.BackLookz.Controllers;

import com.example.BackLookz.Entities.Producto;
import com.example.BackLookz.Entities.enums.TipoProducto;
import com.example.BackLookz.Repositories.ProductoRepository;
import com.example.BackLookz.Services.ProductoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController extends BaseController<Producto, Long, ProductoRepository, ProductoService> {
    public ProductoController(ProductoService service) {
        super(service);
    }


    @GetMapping("/paginado")
    public ResponseEntity<Page<Producto>> obtenerProductosPaginado(
            Pageable pageable) {
        try {
            Page<Producto> pagina = service.obtenerPaginado(pageable);
            return ResponseEntity.ok(pagina);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/filtrar-tipo")
    public ResponseEntity<?> filtrarPorTipoProducto(@RequestParam TipoProducto tipo) {
        try {
            List<Producto> productos = service.filtrarPorTipoProducto(tipo);
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

}
