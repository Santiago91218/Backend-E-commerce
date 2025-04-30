package com.example.BackLookz.Repositories;

import com.example.BackLookz.Entities.Detalle;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository extends BaseRepository<Detalle, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Detalle d SET d.stock = d.stock + :cantidadStock WHERE d.id = :detalleId")
    void setStockById(Long detalleId, int cantidadStock);

}
