package com.example.BackLookz.Services;

import com.example.BackLookz.Repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public abstract class BaseService<T,ID,Repo extends BaseRepository<T,ID>> {

    protected Repo repository;

    @Autowired
    public BaseService(Repo repository) {
        this.repository = repository;
    }


    public List<T> obtenerTodos() throws Exception{
        try {
            return repository.findAll();
        }catch (Exception e){
            throw new Exception("Error al buscar todos:"+e.getMessage());
        }
    }

    public Optional<T> buscarPorId(ID id) throws Exception{
        try{
            return repository.findById(id);
        }catch (Exception e){
            throw new Exception("Error al buscar por id: "+e.getMessage());
        }
    }

    public T crear(T entity) throws Exception {
        try{
            return repository.save(entity);
        }catch (Exception e) {
            throw new Exception("Error al crear: "+e.getMessage());
        }
    }

    public T actualizar(ID id,T entity) throws Exception {
        try{
            Optional<T> existente = repository.findById(id);
            if (existente.isPresent()){
                return repository.save(entity);
            }else{
                throw new Exception("No se encontro el id: "+id);
            }
        }catch (Exception e){
            throw new Exception("Error al actualizar: "+e.getMessage());
        }
    }

    public void eliminarPorId(ID id) throws Exception {
        try{
            repository.deleteById(id);
        }catch (Exception e){
            throw new Exception("Error al eliminar: "+e.getMessage());
        }
    }

}