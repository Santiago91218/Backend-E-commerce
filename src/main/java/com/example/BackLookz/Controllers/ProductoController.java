package com.example.BackLookz.Controllers;

import com.example.BackLookz.Entities.Producto;
import com.example.BackLookz.Repositories.ProductoRepository;
import com.example.BackLookz.Services.ProductoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductoController extends BaseController<Producto, Long, ProductoRepository, ProductoService> {
    public ProductoController(ProductoService service) {
        super(service);
    }
}
