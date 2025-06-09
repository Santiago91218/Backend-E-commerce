package com.example.BackLookz.Repositories;

import com.example.BackLookz.Entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductoRepository extends BaseRepository<Producto, Long> {

    Page<Producto> findByDisponibleTrue(Pageable pageable);
}
