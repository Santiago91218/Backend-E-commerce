package com.example.BackLookz.Services;

import com.example.BackLookz.Entities.Talle;
import com.example.BackLookz.Repositories.TalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalleService extends BaseService<Talle, Long, TalleRepository> {
    public TalleService(TalleRepository repository) {
        super(repository);
    }

    public List<Talle> filtrarPorTalle(String talle) {
        return repository.findByTalleContainingIgnoreCase(talle);
    }

}

