package com.prueba.api.services;

import java.util.List;
import java.util.Optional;
import com.prueba.api.models.Album;


public interface AlbumService {

    public List<Album> obtenerAlbums();
    public Album saveAlbum(Album album);
    public Optional<Album> getAlbumById(Long id);
    public boolean deleteAlbum(Long id);

}
