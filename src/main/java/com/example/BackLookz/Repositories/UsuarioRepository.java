package com.example.BackLookz.Repositories;

import com.example.BackLookz.Entities.Usuario;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario,Long>{
    Optional<Usuario> findByEmail(String email);
}
