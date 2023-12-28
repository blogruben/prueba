package com.prueba.api.services;

import java.util.List;
import com.prueba.api.models.Album;
import com.prueba.api.models.Photo;

public interface ApiService {

    public List<Album> enrichAlbums();
    public List<Album> retrieveAlbums();
    public List<Photo> retrievePhotos();
    public Album getAlbumById(Long id);
    
}
