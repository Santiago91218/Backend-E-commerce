package com.example.BackLookz.Services;

import com.example.BackLookz.DTO.PrecioDTO;
import com.example.BackLookz.Entities.Precio;
import com.example.BackLookz.Repositories.PrecioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrecioService extends BaseService<Precio, Long, PrecioRepository> {

    public PrecioService(PrecioRepository repo) {
        super(repo);
    }

    public List<PrecioDTO> filtrarPorRangoDePrecio(Double min, Double max) throws Exception {
        try{
            List<Precio> precios = repository.findByPrecioVentaBetween(min, max);
            return precios.stream()
                    .map(p -> new PrecioDTO(p.getPrecioCompra(), p.getPrecioVenta()))
                    .collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception("Error al filtrar por precio: " + e.getMessage());
        }
    }
}

