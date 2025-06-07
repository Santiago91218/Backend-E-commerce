package com.example.BackLookz.Repositories;

import com.example.BackLookz.Entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario,Long>{
    Optional<Usuario> findByEmail(String email);

    Page<Usuario> findByDisponibleTrue(Pageable pageable);
}
