package com.prueba.api.services;

import java.util.ArrayList;
import java.util.Optional;
import com.prueba.api.models.AlbumModel;


public interface AlbumService {

    public ArrayList<AlbumModel> obtenerAlbums();
    public AlbumModel saveAlbum(AlbumModel album);
    public Optional<AlbumModel> getAlbumById(Long id);
    public boolean deleteAlbum(Long id);

}
