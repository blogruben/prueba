package com.prueba.api.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.api.models.PhotoModel;
import com.prueba.api.repositories.PhotoRepository;


//tipo clase de tipo Service que hace la logica y llama a repository
//Con autowired spring lo instancia 
@Service
public class PhotoService {
    @Autowired
    PhotoRepository photoRepository;

    public ArrayList<PhotoModel> obtenerUsuarios(){
        return (ArrayList<PhotoModel>) photoRepository.findAll();
    }

    public PhotoModel savePhoto(PhotoModel photo){
        return photoRepository.save(photo);
    }

    public Optional<PhotoModel> obtenerFotoPorId(Long id){
        return photoRepository.findById(id);
    }

    public boolean deletePhoto(Long id){
        try{
            photoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
        
    }
}
