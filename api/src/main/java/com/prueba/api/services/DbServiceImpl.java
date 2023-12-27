package com.prueba.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.api.models.Album;
import com.prueba.api.models.Photo;
import com.prueba.api.repositories.AlbumRepository;
import com.prueba.api.repositories.PhotoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DbServiceImpl implements DbService {

    private AlbumRepository albumRepository;
    private PhotoRepository photoRepository;
    private ApiService apiService;

    @Autowired
    public DbServiceImpl(AlbumRepository albumRepository, PhotoRepository photoRepository, ApiService apiService) {
        this.albumRepository = albumRepository;
        this.photoRepository = photoRepository;
        this.apiService = apiService;
    }

    @Override
    public List<Album> obtenerAlbums(){
        log.info("obtenerAlbums");
        return (ArrayList<Album>) albumRepository.findAll();
    }

    @Override
    public Optional<Album> getAlbumById(Long id){
        return albumRepository.findById(id);
    }

    @Override
    public String saveAllAlbumsFromAPIintoDB(){
        List<Album> albums = apiService.retrieveAlbums();
        albumRepository.saveAll(albums);
        List<Photo> photos = apiService.retrievePhotos();
        photoRepository.saveAll(photos);
        return "save all";
    }

}
