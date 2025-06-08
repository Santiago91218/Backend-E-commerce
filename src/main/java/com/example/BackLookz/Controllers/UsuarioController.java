package com.example.BackLookz.Controllers;

import com.example.BackLookz.DTO.UsuarioDTO;
import com.example.BackLookz.Entities.Direccion;
import com.example.BackLookz.Entities.Usuario;
import com.example.BackLookz.Repositories.UsuarioRepository;
import com.example.BackLookz.Services.UsuarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("usuarios")
@RestController
public class UsuarioController extends BaseController<Usuario,Long, UsuarioRepository, UsuarioService>{

    public UsuarioController(UsuarioService service) {
        super(service);
    }

    @GetMapping("/DTO/{id}")
    public ResponseEntity<?> obtenerUsuaioPorIdDTO(@PathVariable Long id) {
        try {
            UsuarioDTO ususarioDTO = service.obtenerUsuarioDTO(id);
            return ResponseEntity.ok(ususarioDTO);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener usuarioDTO: " + e.getMessage());
        }
    }

    @GetMapping("/DTO")
    public ResponseEntity<?> obtenerTodosLosUsuariosDTO() {
        try {
            List<UsuarioDTO> usuariosDTO = service.obtenerTodosLosUsuariosDTO();
            return ResponseEntity.ok(usuariosDTO);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener los usuarios: " + e.getMessage());
        }
    }

    @PutMapping("/DTO/{id}")
    public ResponseEntity<?> actualizarUsuario(@RequestBody UsuarioDTO dto) {
        try {
            UsuarioDTO actualizado = service.actualizarUsuarioDTO(dto);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el usuario: " + e.getMessage());
        }
    }

    @GetMapping("/paginado")
    public ResponseEntity<Page<Usuario>> obtenerCategoriasPaginado(
            Pageable pageable) {
        try {
            Page<Usuario> pagina = service.obtenerPaginado(pageable);
            return ResponseEntity.ok(pagina);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}/direcciones")
    public ResponseEntity<List<Direccion>> obtenerDireccionesUsuario(@PathVariable Long id) {
        try{
            List<Direccion> direccionesUser = service.obtenerDireccionesDeUsuario(id);
            return ResponseEntity.ok(direccionesUser);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();

        }

    }
}
