package com.example.BackLookz.Controllers;

import com.example.BackLookz.Entities.Imagen;
import com.example.BackLookz.Repositories.ImagenRepository;
import com.example.BackLookz.Services.ImagenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/imagenes")
public class ImagenController extends BaseController<Imagen, Long, ImagenRepository, ImagenService> {

    public ImagenController(ImagenService service) {
        super(service);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<List<Imagen>> obtenerImagenesPorDetalle(@PathVariable Long id) {
        try {
            List<Imagen> imagenes = service.obtenerImagenesPorDetalle(id);
            return ResponseEntity.ok(imagenes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
