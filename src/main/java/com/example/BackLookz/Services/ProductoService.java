package com.example.BackLookz.Services;

import com.example.BackLookz.Entities.Producto;
import com.example.BackLookz.Repositories.DetalleRepository;
import com.example.BackLookz.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoService extends BaseService<Producto, Long, ProductoRepository> {
    public ProductoService(ProductoRepository repository) {
        super(repository);
    }

    @Autowired
    private DetalleRepository detalleRepository;

    public Page<Producto> obtenerPaginado(Pageable pageable) throws Exception {
        try {
            return repository.findByDisponibleTrue(pageable);
        } catch (Exception e) {
            throw new Exception("Error al obtener productos paginados: " + e.getMessage());
        }
    }

    @Transactional
    @Override
    public void eliminarPorId(Long id) throws Exception {
        // Primero eliminás los detalles lógicamente
        detalleRepository.marcarDetallesComoInactivosPorProducto(id);

        // Después llamás al método genérico para eliminar el producto
        super.eliminarPorId(id);
    }

}
