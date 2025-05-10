package com.example.BackLookz.Services;

import com.example.BackLookz.Entities.Producto;
import com.example.BackLookz.Repositories.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoService extends BaseService<Producto, Long, ProductoRepository> {
    public ProductoService(ProductoRepository repository) {
        super(repository);
    }
}
