package com.example.BackLookz.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T,ID> extends JpaRepository<T,ID> {

    List<T> findByDisponibleTrue();

}
