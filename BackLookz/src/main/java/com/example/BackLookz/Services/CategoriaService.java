package com.example.BackLookz.Services;

import com.example.BackLookz.Entities.Categoria;
import com.example.BackLookz.Repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends BaseService<Categoria,Long,CategoriaRepository>{

    public CategoriaService(CategoriaRepository repository) {
        super(repository);
    }

}
