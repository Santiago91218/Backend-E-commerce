package com.example.BackLookz.Controllers;

import com.example.BackLookz.Entities.Precio;
import com.example.BackLookz.Services.PrecioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/precios") //"api" tenemos que modificarlo
public class PrecioController extends BaseController<Precio, Long> {

    public PrecioController(PrecioService service) {
        super(service);
    }
}