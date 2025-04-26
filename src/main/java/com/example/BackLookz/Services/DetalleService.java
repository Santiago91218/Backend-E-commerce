package com.example.BackLookz.Services;

import com.example.BackLookz.Entities.Detalle;
import com.example.BackLookz.Repositories.DetalleRepository;
import org.springframework.stereotype.Service;

@Service
public class DetalleService extends BaseService<Detalle, Long, DetalleRepository> {
    public DetalleService(DetalleRepository repo) {
        super(repo);
    }
}
