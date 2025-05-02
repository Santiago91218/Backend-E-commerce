package com.example.BackLookz.Repositories;

import com.example.BackLookz.Entities.Detalle;
import com.example.BackLookz.Entities.enums.GeneroProducto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleRepository extends BaseRepository<Detalle, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Detalle d SET d.stock = d.stock + :cantidadStock WHERE d.id = :detalleId")
    void setStockById(Long detalleId, int cantidadStock);

    @Modifying
    @Transactional
    @Query("SELECT d FROM Detalle d WHERE d.producto.generoProducto = :generoProducto")
    List<Detalle> findBySexo(GeneroProducto generoProducto);

}
