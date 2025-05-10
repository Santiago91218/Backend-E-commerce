package com.example.BackLookz.Repositories;

import com.example.BackLookz.Entities.Talle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TalleRepository extends BaseRepository<Talle, Long> {
    @Query("SELECT t FROM Talle t WHERE LOWER(t.talle) LIKE LOWER(CONCAT('%', :talle, '%'))")
    List<Talle> findByTalleContainingIgnoreCase(@Param("talle") String talle);
}
