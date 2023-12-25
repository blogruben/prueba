package com.prueba.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.prueba.api.models.PhotoModel;

public interface PhotoService {

    public ArrayList<PhotoModel> getAllPhotos();
    public PhotoModel savePhoto(PhotoModel photo);
    public List<PhotoModel> savePhotoList(ArrayList<PhotoModel> photoList);
    public Optional<PhotoModel> obtenerPhotosPorId(Long id);
    public boolean deletePhoto(Long id);
    
}
