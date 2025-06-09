package com.example.BackLookz.Controllers;

import com.example.BackLookz.Entities.Producto;
import com.example.BackLookz.Repositories.ProductoRepository;
import com.example.BackLookz.Services.ProductoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
