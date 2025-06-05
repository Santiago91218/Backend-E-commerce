package com.example.BackLookz.Services;

import com.example.BackLookz.DTO.UsuarioDTO;
import com.example.BackLookz.Entities.Direccion;
import com.example.BackLookz.Entities.Usuario;
import com.example.BackLookz.Repositories.DireccionRepository;
import com.example.BackLookz.Repositories.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Page<Usuario> obtenerPaginado(Pageable pageable) throws Exception {
        try {
            return repository.findAll(pageable);
        } catch (Exception e) {
            throw new Exception("Error al obtener categorías paginadas: " + e.getMessage());
        }
    }


    public UsuarioDTO obtenerUsuarioDTO(Long id) throws Exception {

        Optional<Usuario> usuarioOpt = repository.findById(id);

        if(!usuarioOpt.isPresent()){
            throw new Exception("No se encotro el usuario");
        }

        Usuario usuario = usuarioOpt.get();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setRol(usuario.getRol());

        return usuarioDTO;
    }

    public List<UsuarioDTO> obtenerTodosLosUsuariosDTO() {
        List<Usuario> usuarios = repository.findAll();
        return usuarios.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO actualizarUsuarioDTO(UsuarioDTO dto) throws Exception {
        Optional<Usuario> usuarioOpt = repository.findById(dto.getId());

        if (!usuarioOpt.isPresent()) {
            throw new Exception("Usuario no encontrado");
        }

        Usuario usuario = usuarioOpt.get();

        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setRol(dto.getRol());

        Usuario actualizado = repository.save(usuario);

        return convertirADTO(actualizado);
    }

    public UsuarioDTO convertirADTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setEmail(usuario.getEmail());
        dto.setRol(usuario.getRol());

        return dto;
    }

}
