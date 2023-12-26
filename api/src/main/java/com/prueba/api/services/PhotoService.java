package com.prueba.api.services;

import java.util.List;
import java.util.Optional;
import com.prueba.api.models.Photo;

public interface PhotoService {

    public List<Photo> getAllPhotos();
    public Photo savePhoto(Photo photo);
    public List<Photo> savePhotoList(List<Photo> photoList);
    public Optional<Photo> obtenerPhotosPorId(Long id);
    public boolean deletePhoto(Long id);
    
}
