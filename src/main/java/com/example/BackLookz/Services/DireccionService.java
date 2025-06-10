package com.example.BackLookz.Services;

import com.example.BackLookz.DTO.DireccionDTO;
import com.example.BackLookz.DTO.UsuarioDTO;
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

    public DireccionDTO crearYRetornarDTO(Direccion direccion) throws Exception {
        try {
            Usuario usuario = usuarioRepository.findById(direccion.getUsuario().getId())
                    .orElseThrow(() -> new Exception("Usuario no encontrado"));

            Direccion direccionGuardada = repository.save(direccion);

            usuario.getDirecciones().add(direccionGuardada);
            usuarioRepository.save(usuario);

            UsuarioDTO usuarioDTO = new UsuarioDTO(
                    usuario.getId(),
                    usuario.getNombre(),
                    usuario.getEmail(),
                    usuario.getRol()
            );

            return new DireccionDTO(
                    direccionGuardada.getId(),
                    direccionGuardada.getCalle(),
                    direccionGuardada.getNumero(),
                    direccionGuardada.getLocalidad(),
                    direccionGuardada.getProvincia(),
                    direccionGuardada.getPais(),
                    direccionGuardada.getCodigoPostal(),
                    direccionGuardada.isDisponible(),
                    direccionGuardada.getDepartamento(),
                    usuarioDTO
            );
        } catch (Exception e) {
            throw new Exception("Error al crear dirección: " + e.getMessage(), e);
        }
    }

}
