package com.prueba.api.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.api.models.UsuarioModel;
import com.prueba.api.repositories.UsuarioRepository;


//tipo clase de tipo Service que hace la logica y llama a repository
//Con autowired spring lo instancia 
@Service
public class AlbumService {
    @Autowired
    UsuarioRepository usuarioRepository;


    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    //Registramos el Usuario y devolvemos el mismo
    //usuario que hemos grabado pero con el ID asignado
    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerUsuarioPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
        
    }
}
