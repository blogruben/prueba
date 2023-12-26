package com.prueba.api.services;

import java.util.List;
import java.util.Optional;
import com.prueba.api.models.Album;

public interface ApiService {

    public List<Album> enrichAlbums();
    public Optional<Album> getAlbumById(Long id);
    
}
