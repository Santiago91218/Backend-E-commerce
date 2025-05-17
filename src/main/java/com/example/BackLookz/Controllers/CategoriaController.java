package com.example.BackLookz.Controllers;

import com.example.BackLookz.Entities.Categoria;
import com.example.BackLookz.Repositories.CategoriaRepository;
import com.example.BackLookz.Services.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaController extends BaseController<Categoria,Long, CategoriaRepository, CategoriaService> {

    public CategoriaController(CategoriaService service) {
        super(service);
    }
    @GetMapping("/filtrar")
    public ResponseEntity<?> filtrarPorNombre(@RequestParam String nombre) {
        try {
            List<Categoria> categorias = service.filtrarPorNombre(nombre);
            return ResponseEntity.ok(categorias);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

}
