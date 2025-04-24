package com.example.BackLookz.Controllers;

import com.example.BackLookz.Entities.Descuento;
import com.example.BackLookz.Services.DescuentoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/descuentos") //"api" tenemos que modificarlo
public class DescuentoController extends BaseController<Descuento, Long> {

    public DescuentoController(DescuentoService service) {
        super(service);
    }
}