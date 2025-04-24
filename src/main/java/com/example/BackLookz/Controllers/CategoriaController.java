package com.example.BackLookz.Controllers;

import com.example.BackLookz.Entities.Categoria;
import com.example.BackLookz.Repositories.CategoriaRepository;
import com.example.BackLookz.Services.CategoriaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("categorias")
@RestController
public class CategoriaController extends BaseController<Categoria,Long, CategoriaRepository, CategoriaService> {

    public CategoriaController(CategoriaService service) {
        super(service);
    }

}
