package com.example.BackLookz.Repositories;

import com.example.BackLookz.Entities.Precio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrecioRepository extends BaseRepository<Precio, Long> {

    @Query("SELECT p FROM Precio p WHERE p.precioVenta BETWEEN :min AND :max")
    List<Precio> findByPrecioVentaBetween(@Param("min") Double min, @Param("max") Double max);

}