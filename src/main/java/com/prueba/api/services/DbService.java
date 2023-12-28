package com.prueba.api.services;

import java.util.List;
import java.util.Optional;
import com.prueba.api.models.Album;

public interface DbService {

    public List<Album> retrieveAlbums();
    public Optional<Album> getAlbumById(Long id);
    public String saveAllAlbumsFromAPIintoDB();

}