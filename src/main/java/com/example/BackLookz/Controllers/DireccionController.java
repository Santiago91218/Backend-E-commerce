package com.example.BackLookz.Controllers;

import com.example.BackLookz.Entities.Direccion;
import com.example.BackLookz.Repositories.DireccionRepository;
import com.example.BackLookz.Services.DireccionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("direcciones")
@RestController
public class DireccionController extends BaseController<Direccion,Long, DireccionRepository, DireccionService>{

    public DireccionController(DireccionService service) {
        super(service);
    }

}
