package com.example.BackLookz.Controllers;

import com.example.BackLookz.Entities.Detalle;
import com.example.BackLookz.Repositories.DetalleRepository;
import com.example.BackLookz.Services.DetalleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detalles")
public class DetalleController extends BaseController<Detalle, Long, DetalleRepository, DetalleService> {
    public DetalleController(DetalleService service) {
        super(service);
    }
}
