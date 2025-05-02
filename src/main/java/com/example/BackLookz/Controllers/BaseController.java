package com.example.BackLookz.Controllers;

import com.example.BackLookz.Repositories.BaseRepository;
import com.example.BackLookz.Services.BaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("lookz")
public abstract class BaseController<T,ID, Repo extends BaseRepository<T,ID>,Service extends BaseService<T,ID,Repo>>{

    protected final Service service;

    public BaseController(Service service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<T>> obtenerTodos(){
        try{
            List<T> lista = service.obtenerTodos();
            return ResponseEntity.ok(lista);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> buscarPorId(@PathVariable ID id) throws Exception{
        try {
            Optional<T> resultado = service.buscarPorId(id);
            if (resultado.isPresent()) {
                return ResponseEntity.ok(resultado.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<T> crear(@RequestBody T entity){
        try{
            T nuevo = service.crear(entity);
            return ResponseEntity.ok(nuevo);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> actualizar(@PathVariable ID id, @RequestBody T entity){
        try{
            Optional<T> existente = service.buscarPorId(id);
            if (existente.isPresent()){
                T actualizado = service.actualizar(id,entity);
                return ResponseEntity.ok(actualizado);
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<T>> eliminarPorId(@PathVariable ID id){
        try{
            service.eliminarPorId(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

}
