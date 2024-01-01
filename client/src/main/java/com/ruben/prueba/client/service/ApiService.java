package com.ruben.prueba.client.service;

import java.util.List;
import java.util.Optional;
import com.ruben.prueba.client.models.AlbumApi;

public interface ApiService {

    public List<AlbumApi> getEnrichedAlbums();
    public Optional<AlbumApi> getAlbumById(Long id);
    
}
