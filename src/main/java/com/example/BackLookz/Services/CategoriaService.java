package com.example.BackLookz.Services;

import com.example.BackLookz.Entities.Categoria;
import com.example.BackLookz.Repositories.CategoriaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaService extends BaseService<Categoria,Long,CategoriaRepository>{

    public CategoriaService(CategoriaRepository repository) {
        super(repository);
    }

    public List<Categoria> filtrarPorNombre(String nombre) throws Exception {
        try {
            return repository.findByNombreContainingIgnoreCase(nombre);
        } catch (Exception e) {
            throw new Exception("Error al filtrar categorías por nombre: " + e.getMessage());
        }
    }

    public Page<Categoria> obtenerPaginado(Pageable pageable) throws Exception {
        try {
            return repository.findByDisponibleTrue(pageable);
        } catch (Exception e) {
            throw new Exception("Error al obtener categorias paginadas: " + e.getMessage());
        }
    }

}
