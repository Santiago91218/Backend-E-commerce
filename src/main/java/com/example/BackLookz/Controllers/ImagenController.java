package com.example.BackLookz.Controllers;

import com.example.BackLookz.Entities.Imagen;
import com.example.BackLookz.Repositories.ImagenRepository;
import com.example.BackLookz.Services.ImagenService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/imagenes") //"api" tenemos que modificarlo
public class ImagenController extends BaseController<Imagen, Long, ImagenRepository, ImagenService> {

    public ImagenController(ImagenService service) {
        super(service);
    }
}
