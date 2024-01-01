package com.ruben.prueba.app.services;

import java.util.List;
import java.util.Optional;

import com.ruben.prueba.app.models.AlbumModel;

public interface AlbumService {

    public List<AlbumModel> getAllAlbumsFromDB();
    public List<AlbumModel> getAllAlbumsFromApi();
    public AlbumModel getAlbumByIdFromApi(Long id);
    public Optional<AlbumModel> getAlbumByIdFromDb(Long id);
    public String saveAllAlbumsFromAPIintoDB();

}
