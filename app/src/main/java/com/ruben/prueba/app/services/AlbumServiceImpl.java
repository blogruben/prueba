package com.ruben.prueba.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ruben.prueba.app.models.AlbumModel;
import com.ruben.prueba.app.repositories.AlbumRepository;
import com.ruben.prueba.app.repositories.PhotoRepository;
import com.ruben.prueba.client.models.AlbumApi;
import com.ruben.prueba.client.service.ApiService;

import lombok.extern.slf4j.Slf4j;




@Slf4j
@Service
public class AlbumServiceImpl implements AlbumService {

    private AlbumRepository albumRepository;
    private PhotoRepository photoRepository;
    //private MapearAlbums mapearAlbums;
    private ApiService apiService;
    private MapearAlbums mapearAlbums;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository, PhotoRepository photoRepository, ApiService apiService) {
        this.mapearAlbums = Mappers.getMapper( MapearAlbums.class );
        this.albumRepository = albumRepository;
        this.photoRepository = photoRepository;
        this.apiService = apiService;
    }

    @Override
    public List<AlbumModel> getAllAlbumsFromDB(){
        log.info("obtenerAlbums");
        return (List<AlbumModel>) albumRepository.findAll();
    }

    @Override
    public List<AlbumModel> getAllAlbumsFromApi(){
        log.info("obtenerAlbums");
        List<AlbumApi> albumApiList = apiService.getEnrichedAlbums();
        return albumApiList.stream().map(album -> {
            return this.mapearAlbums.mapear(album);
        }).collect(Collectors.toList());
    }
    
    @Override
    public AlbumModel getAlbumByIdFromApi(Long id){
        AlbumApi albumApi = apiService.getAlbumById(id).get();
        if(apiService.getAlbumById(id).get() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);  
        }
        log.info(albumApi.toString());
        AlbumModel albumModel = this.mapearAlbums.mapear(albumApi);
        log.info(albumModel.toString());
        return albumModel;
    }


    @Override
    public Optional<AlbumModel> getAlbumByIdFromDb(Long id){
        return albumRepository.findById(id);
    }

    @Override
    public String saveAllAlbumsFromAPIintoDB(){
        albumRepository.saveAll(this.getAllAlbumsFromApi());
        return "All albums with the corresponding photos are saved in the db SUCCESSFULLY.";
    }

}
