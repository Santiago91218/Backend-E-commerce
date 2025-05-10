package com.example.BackLookz.Controllers;

import com.example.BackLookz.Entities.OrdenCompra;
import com.example.BackLookz.Repositories.OrdenCompraRepository;
import com.example.BackLookz.Services.OrdenCompraService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordenes-compra")
public class OrdenCompraController extends BaseController<OrdenCompra, Long, OrdenCompraRepository, OrdenCompraService> {

    public OrdenCompraController(OrdenCompraService service) {
        super(service);
    }

}
