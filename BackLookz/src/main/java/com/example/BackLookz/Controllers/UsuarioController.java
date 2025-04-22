package com.example.BackLookz.Controllers;

import com.example.BackLookz.Entities.Usuario;
import com.example.BackLookz.Repositories.UsuarioRepository;
import com.example.BackLookz.Services.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("usuarios")
@RestController
public class UsuarioController extends BaseController<Usuario,Long, UsuarioRepository, UsuarioService>{

    public UsuarioController(UsuarioService service) {
        super(service);
    }

}
