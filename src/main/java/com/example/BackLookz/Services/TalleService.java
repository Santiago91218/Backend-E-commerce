package com.example.BackLookz.Services;

import com.example.BackLookz.Entities.Talle;
import com.example.BackLookz.Repositories.TalleRepository;
import org.springframework.stereotype.Service;

@Service
public class TalleService extends BaseService<Talle, Long, TalleRepository> {
    public TalleService(TalleRepository repository) {
        super(repository);
    }
}

