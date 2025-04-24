package com.example.BackLookz.Services;

import com.example.BackLookz.Entities.Imagen;
import com.example.BackLookz.Repositories.ImagenRepository;
import org.springframework.stereotype.Service;

@Service
public class ImagenService extends BaseService<Imagen, Long> {

    public ImagenService(ImagenRepository repo) {
        super(repo);
    }
}