package com.example.BackLookz.Services;

import com.example.BackLookz.DTO.DetalleDTO;
import com.example.BackLookz.Entities.Detalle;
import com.example.BackLookz.Entities.Imagen;
import com.example.BackLookz.Entities.enums.GeneroProducto;
import com.example.BackLookz.Repositories.DetalleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Transactional
    public List<DetalleDTO> filtrarPorSexo(GeneroProducto generoProducto) throws Exception{
        try{
           List<Detalle> detalles = repository.findBySexo(generoProducto);
            return detalles.stream()
                    .map(this::convertirADTO)
                    .collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception("Error al filtrar por sexo: "+e.getMessage());
        }
    }



    public DetalleDTO obtenerDetalleDTO(Long id) throws Exception {

        Optional<Detalle> detalleOpt = repository.findById(id);

        if(!detalleOpt.isPresent()){
            throw new Exception("No se encotro el detalle");
        }

        Detalle detalle = detalleOpt.get();

        Imagen imagenPrincipal;

        if(detalle.getImagenes() != null && !detalle.getImagenes().isEmpty()){
            imagenPrincipal= detalle.getImagenes().get(0);
        }else{
           imagenPrincipal = null;
        }

        DetalleDTO detalleDTO = new DetalleDTO();
        detalleDTO.setId(detalle.getId());
        detalleDTO.setProducto(detalle.getProducto());
        detalleDTO.setPrecio(detalle.getPrecio());
        detalleDTO.setImagenPrincipal(imagenPrincipal);

        return detalleDTO;
    }

    public List<DetalleDTO> obtenerTodosLosDetalleDTO() {
        List<Detalle> detalles = repository.findAll();
        return detalles.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public DetalleDTO convertirADTO(Detalle detalle) {
        DetalleDTO dto = new DetalleDTO();
        dto.setId(detalle.getId());
        dto.setProducto(detalle.getProducto());
        dto.setPrecio(detalle.getPrecio());

        if (!detalle.getImagenes().isEmpty()) {
            dto.setImagenPrincipal(detalle.getImagenes().get(0));
        }

        return dto;
    }


}
