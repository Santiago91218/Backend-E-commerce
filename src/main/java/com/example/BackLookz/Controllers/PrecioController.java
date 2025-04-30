package com.example.BackLookz.Controllers;

import com.example.BackLookz.Entities.Precio;
import com.example.BackLookz.Repositories.PrecioRepository;
import com.example.BackLookz.Services.PrecioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/precios")
public class PrecioController extends BaseController<Precio, Long, PrecioRepository,PrecioService> {

    public PrecioController(PrecioService service) {
        super(service);
    }
}