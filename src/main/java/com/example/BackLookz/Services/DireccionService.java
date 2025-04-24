package com.example.BackLookz.Services;

import com.example.BackLookz.Entities.Direccion;
import com.example.BackLookz.Repositories.DireccionRepository;
import org.springframework.stereotype.Service;

@Service
public class DireccionService extends BaseService<Direccion,Long, DireccionRepository> {

    public DireccionService(DireccionRepository repository) {
        super(repository);
    }

}
