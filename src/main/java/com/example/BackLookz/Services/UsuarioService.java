package com.example.BackLookz.Services;

import com.example.BackLookz.Entities.Usuario;
import com.example.BackLookz.Repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends BaseService<Usuario,Long, UsuarioRepository>{

    public UsuarioService(UsuarioRepository repository) {
        super(repository);
    }

}
