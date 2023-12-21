package com.prueba.api.repositories;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.prueba.api.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    //otros posibles metodos finByNombre findByEmail
    //no hace falta implementar si tiene el nombre bien
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
}

