package com.example.BackLookz.Services;

import com.example.BackLookz.Entities.Producto;
import com.example.BackLookz.Repositories.ProductoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductoService extends BaseService<Producto, Long, ProductoRepository> {
    public ProductoService(ProductoRepository repository) {
        super(repository);
    }


    public Page<Producto> obtenerPaginado(Pageable pageable) throws Exception {
        try {
            return repository.findByDisponibleTrue(pageable);
        } catch (Exception e) {
            throw new Exception("Error al obtener productos paginados: " + e.getMessage());
        }
    }
}
