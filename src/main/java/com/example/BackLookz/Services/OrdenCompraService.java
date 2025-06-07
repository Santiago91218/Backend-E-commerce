package com.example.BackLookz.Services;

import com.example.BackLookz.Entities.OrdenCompra;
import com.example.BackLookz.Repositories.OrdenCompraRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdenCompraService extends BaseService<OrdenCompra, Long, OrdenCompraRepository> {

    public OrdenCompraService(OrdenCompraRepository repository) {
        super(repository);
    }

    @Transactional
    public List<OrdenCompra> obtenerOrdenesPorUsuarioId(Long usuarioId) throws Exception{
        try{
            return repository.findByUsuarioId(usuarioId);
        }catch (Exception e){
            throw  new Exception("Error al obtener ordenes de usuario"+e.getMessage());

        }
    }

}
