package com.prueba.api.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.api.models.AlbumModel;
import com.prueba.api.repositories.AlbumRepository;


public interface AlbumService {

    public ArrayList<AlbumModel> obtenerAlbums();
    public AlbumModel saveAlbum(AlbumModel album);
    public Optional<AlbumModel> getAlbumById(Long id);
    public boolean deleteAlbum(Long id);

}
