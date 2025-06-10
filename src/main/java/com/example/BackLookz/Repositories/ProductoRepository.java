package com.example.BackLookz.Repositories;

import com.example.BackLookz.Entities.Producto;
import com.example.BackLookz.Entities.enums.TipoProducto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends BaseRepository<Producto, Long> {

    Page<Producto> findByDisponibleTrue(Pageable pageable);

    @Query("SELECT p FROM Producto p WHERE p.tipoProducto = :tipo")
    List<Producto> findByTipoProducto(@Param("tipo") TipoProducto tipo);
}
