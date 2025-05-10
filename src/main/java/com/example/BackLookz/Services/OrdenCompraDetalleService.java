package com.example.BackLookz.Services;

import com.example.BackLookz.Entities.OrdenCompraDetalle;
import com.example.BackLookz.Repositories.OrdenCompraDetalleRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdenCompraDetalleService extends BaseService<OrdenCompraDetalle, Long, OrdenCompraDetalleRepository> {

    public OrdenCompraDetalleService(OrdenCompraDetalleRepository repository) {
        super(repository);
    }

}
