package com.example.BackLookz.Repositories;

import com.example.BackLookz.Entities.Imagen;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagenRepository extends BaseRepository<Imagen, Long> {

    List<Imagen> findByDetalleId(Long detalleId);



}