package com.example.BackLookz.Services;

import com.example.BackLookz.Entities.Detalle;
import com.example.BackLookz.Repositories.DetalleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DetalleService extends BaseService<Detalle, Long, DetalleRepository> {

    public DetalleService(DetalleRepository repository) {
        super(repository);
    }


    @Transactional
    public void agregarStock(Long idDetalle, int cantidadStock) throws Exception{
    try{
      repository.setStockById(idDetalle,cantidadStock);
    }catch (Exception e){
        throw new Exception("Error al agregar stock: "+e.getMessage());
    }

    }

}
