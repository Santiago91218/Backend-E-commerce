package com.example.BackLookz.Services;

import com.example.BackLookz.Entities.Direccion;
import com.example.BackLookz.Entities.Usuario;
import com.example.BackLookz.Repositories.DireccionRepository;
import com.example.BackLookz.Repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionService extends BaseService<Direccion, Long, DireccionRepository> {

    private final UsuarioRepository usuarioRepository;

    public DireccionService(DireccionRepository repository, UsuarioRepository usuarioRepository) {
        super(repository);
        this.usuarioRepository = usuarioRepository;
    }

    public List<Direccion> obtenerPorUsuarioId(Long usuarioId) {
        return repository.findByUsuariosId(usuarioId);
    }

    @Override
    public Direccion crear(Direccion direccion) throws Exception {
        try {
            // Buscar el usuario principal
            Usuario usuario = usuarioRepository.findById(direccion.getUsuario().getId())
                    .orElseThrow(() -> new Exception("Usuario no encontrado"));

            // Asociar la dirección al usuario (tabla intermedia)
            direccion.getUsuarios().add(usuario);

            // Guardar la dirección con el vínculo correcto
            return repository.save(direccion);
        } catch (Exception e) {
            throw new Exception("Error al crear dirección: " + e.getMessage(), e);
        }
    }
}
