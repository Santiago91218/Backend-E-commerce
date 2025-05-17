package com.example.BackLookz.Services;

import com.example.BackLookz.Entities.Detalle;
import com.example.BackLookz.Entities.Imagen;
import com.example.BackLookz.Repositories.DetalleRepository;
import com.example.BackLookz.Repositories.ImagenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class ImagenService extends BaseService<Imagen, Long, ImagenRepository> {

    private final DetalleRepository detalleRepository;


    public ImagenService(ImagenRepository repo,DetalleRepository detalleRepository) {
        super(repo);
        this.detalleRepository= detalleRepository;
    }

    @Override
    @Transactional
    public Imagen crear(Imagen imagen) throws Exception {

        Optional<Detalle> detalleOpt = detalleRepository.findById(imagen.getDetalle().getId());

        if (!detalleOpt.isPresent()) {
            throw new Exception("Detalle no encontrado en la BD");
        }

        Detalle detalle = detalleOpt.get();


        if (detalle.getImagenes().size() >= 5) {
            throw new Exception("El detalle no puede tener mas de 5 imagenes");
        }

        return repository.save(imagen);
    }

}