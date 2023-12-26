package com.prueba.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.api.models.Photo;
import com.prueba.api.repositories.PhotoRepository;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    PhotoRepository photoRepository;

    @Override
    public ArrayList<Photo> getAllPhotos(){
        return (ArrayList<Photo>) photoRepository.findAll();
    }

    @Override
    public Photo savePhoto(Photo photo){
        log.info("Going to create {}",photo);
        return photoRepository.save(photo);
    }

    @Override
    public List<Photo> savePhotoList(List<Photo> photoList){
        Iterable<Photo> iterable = photoRepository.saveAll(photoList);
        List<Photo> photos = new ArrayList<>();
        iterable.forEach(photos::add);
        return photos;
    }

    @Override
    public Optional<Photo> obtenerPhotosPorId(Long id){
        return photoRepository.findById(id);
    }

    @Override
    public boolean deletePhoto(Long id){
        try{
            photoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    
}
