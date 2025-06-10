package com.example.BackLookz.Repositories;

import com.example.BackLookz.Entities.Detalle;
import com.example.BackLookz.Entities.enums.GeneroProducto;
import com.example.BackLookz.Entities.enums.TipoProducto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DetalleRepository extends BaseRepository<Detalle, Long> {

    @Transactional
    @Query("SELECT d FROM Detalle d WHERE d.producto.generoProducto = :generoProducto AND d.disponible = true")
    List<Detalle> findBySexo(GeneroProducto generoProducto);

    @Transactional
    @Query("SELECT d FROM Detalle d WHERE d.producto.tipoProducto = :tipo AND d.producto.generoProducto = :genero AND d.disponible = true AND d.id <> :id")
    List<Detalle> findByRelacionados(TipoProducto tipo, GeneroProducto genero, Long id);

    List<Detalle> findByProductoIdAndDisponibleTrue(Long productoId);

    @Query("SELECT d FROM Detalle d " +
            "JOIN d.precio p " +
            "LEFT JOIN p.descuento desc " +
            "WHERE d.destacado = true " +
            "OR (desc IS NOT NULL AND CURRENT_DATE BETWEEN desc.fechaInicio AND desc.fechaFin)")
    List<Detalle> findDetallesConDescuentoDestacados();

    @Modifying
    @Transactional
    @Query("UPDATE Detalle d SET d.disponible = false WHERE d.producto.id = :productoId")
    void marcarDetallesComoInactivosPorProducto(@Param("productoId") Long productoId);

}
