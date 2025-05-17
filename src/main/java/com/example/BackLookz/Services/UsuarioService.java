package com.example.BackLookz.Services;

import com.example.BackLookz.Entities.Direccion;
import com.example.BackLookz.Entities.Usuario;
import com.example.BackLookz.Repositories.DireccionRepository;
import com.example.BackLookz.Repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService extends BaseService<Usuario,Long, UsuarioRepository>{

    private final DireccionRepository direccionRepository;

    public UsuarioService(UsuarioRepository repository, DireccionRepository direccionRepository) {
        super(repository);
        this.direccionRepository = direccionRepository;
    }

    @Override
    @Transactional
    public Usuario crear(Usuario usuario) throws Exception {
        List<Direccion> direccionesUser = new ArrayList<>();

        for (Direccion d : usuario.getDirecciones()) {
            Optional<Direccion> direccion = direccionRepository.findById(d.getId());
            if (!direccion.isPresent()){
                throw new Exception("Direcccion no encontrada en la BD");
            }
            Direccion newDireccion = direccion.get();
            //Asociando bro
            newDireccion.getUsuarios().add(usuario);
            direccionesUser.add(newDireccion);
        }

        usuario.setDirecciones(direccionesUser);
        return repository.save(usuario);
    }

}
