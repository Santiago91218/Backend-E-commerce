package com.example.BackLookz.Services;

import com.example.BackLookz.Entities.Descuento;
import com.example.BackLookz.Repositories.DescuentoRepository;
import org.springframework.stereotype.Service;

@Service
public class DescuentoService extends BaseService<Descuento, Long> {

    public DescuentoService(DescuentoRepository repo) {
        super(repo);
    }
}