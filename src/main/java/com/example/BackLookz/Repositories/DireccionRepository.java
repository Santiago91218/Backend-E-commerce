package com.example.BackLookz.Repositories;

import com.example.BackLookz.Entities.Direccion;

import java.util.List;

public interface DireccionRepository extends BaseRepository<Direccion, Long> {
    List<Direccion> findByUsuariosId(Long usuarioId);
}

