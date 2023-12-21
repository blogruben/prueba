package com.prueba.api.repositories;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.prueba.api.models.UsuarioModel;

//tipo clase de tipop Repository hace las conexiones con BBDD
// CrudRepository impleta los metodos para hacer crud a la bbdd
//le pasamos que tipo de dato - UsuarioModel
//y le pasamos el tipo del identificador - Long
@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    //otros posibles metodos finByNombre findByEmail
    //no hace falta implementar si tiene el nombre bien
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
}
