package com.example.BackLookz.Services;

import com.example.BackLookz.Entities.Precio;
import com.example.BackLookz.Repositories.PrecioRepository;
import org.springframework.stereotype.Service;

@Service
public class PrecioService extends BaseService<Precio, Long> {

    public PrecioService(PrecioRepository repo) {
        super(repo);
    }
}