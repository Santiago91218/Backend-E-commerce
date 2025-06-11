package com.example.BackLookz.Services;

import com.example.BackLookz.DTO.DetalleDTO;
import com.example.BackLookz.Entities.Detalle;
import com.example.BackLookz.Entities.Imagen;
import com.example.BackLookz.Entities.enums.GeneroProducto;
import com.example.BackLookz.Entities.enums.TipoProducto;
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

    @Transactional
    public List<DetalleDTO> filtrarProductosRelacionados(TipoProducto tipo, GeneroProducto genero,Long id) throws Exception{
        try{
            List<Detalle> detalles = repository.findByRelacionados(tipo,genero,id);
            return detalles.stream()
                    .map(this::convertirADTO)
                    .collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception("Error al filtrar relacionados: "+e.getMessage());
        }
    }

    @Transactional
    public List<DetalleDTO> obtenerDetallesConDescuentoYDestacados() throws Exception{
        try{
            List<Detalle> detalles = repository.findDetallesConDescuentoDestacados();
            return detalles.stream()
                    .map(this::convertirADTO)
                    .collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception("Error al filtrar relacionados: "+e.getMessage());
        }
    }



    @Transactional
    public List<Detalle> obtenerDetallesPorProducto(Long idProducto) throws Exception{
        try{
            return repository.findByProductoIdAndDisponibleTrue(idProducto);
        }catch (Exception e){
            throw new Exception("Error al obtener detalles: "+ e.getMessage());
        }
    }

    public List<DetalleDTO> filtrarPorRangoDePrecio(Double min, Double max) throws Exception {
        try {
            List<Detalle> detalles = repository.findByPrecioVentaBetween(min, max);
            return detalles.stream()
                    .map(this::convertirADTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception("Error al filtrar detalles por precio: " + e.getMessage());
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
        detalleDTO.setDisponible(detalle.isDisponible());
        detalleDTO.setProducto(detalle.getProducto());
        detalleDTO.setPrecio(detalle.getPrecio());
        detalleDTO.setTalle(detalle.getTalle());
        detalleDTO.setImagenPrincipal(imagenPrincipal);

        return detalleDTO;
    }

    public List<DetalleDTO> obtenerTodosLosDetalleDTO() {
        List<Detalle> detalles = repository.findByDisponibleTrue();
        return detalles.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public DetalleDTO convertirADTO(Detalle detalle) {
        DetalleDTO dto = new DetalleDTO();
        dto.setId(detalle.getId());
        dto.setDisponible(detalle.isDisponible());
        dto.setProducto(detalle.getProducto());
        dto.setPrecio(detalle.getPrecio());
        dto.setTalle(detalle.getTalle());

        if (!detalle.getImagenes().isEmpty()) {
            dto.setImagenPrincipal(detalle.getImagenes().get(0));
        }

        return dto;
    }


}
