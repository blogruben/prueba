package com.prueba.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.api.models.PhotoModel;
import com.prueba.api.repositories.PhotoRepository;


@Service
public class PhotoService {
    @Autowired
    PhotoRepository photoRepository;

    public ArrayList<PhotoModel> getAllPhotos(){
        return (ArrayList<PhotoModel>) photoRepository.findAll();
    }

    public PhotoModel savePhoto(PhotoModel photo){
        return photoRepository.save(photo);
    }

    public List<PhotoModel> savePhotoList(ArrayList<PhotoModel> photoList){
        Iterable<PhotoModel> iterable = photoRepository.saveAll(photoList);
        List<PhotoModel> photos = new ArrayList<>();
        iterable.forEach(photos::add);
        return photos;
    }

    public Optional<PhotoModel> obtenerPhotosPorId(Long id){
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
