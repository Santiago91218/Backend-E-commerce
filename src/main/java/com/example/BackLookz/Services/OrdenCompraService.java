package com.example.BackLookz.Services;

import com.example.BackLookz.Entities.OrdenCompra;
import com.example.BackLookz.Repositories.OrdenCompraRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdenCompraService extends BaseService<OrdenCompra, Long, OrdenCompraRepository> {

    public OrdenCompraService(OrdenCompraRepository repository) {
        super(repository);
    }

}
