package com.example.BackLookz.Controllers;

import com.example.BackLookz.Entities.OrdenCompraDetalle;
import com.example.BackLookz.Repositories.OrdenCompraDetalleRepository;
import com.example.BackLookz.Services.OrdenCompraDetalleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordenes-compra-detalle")
public class OrdenCompraDetalleController extends BaseController<OrdenCompraDetalle, Long, OrdenCompraDetalleRepository, OrdenCompraDetalleService> {

    public OrdenCompraDetalleController(OrdenCompraDetalleService service) {
        super(service);
    }

}
