package com.ruben.prueba.client.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruben.prueba.client.models.AlbumApi;
import com.ruben.prueba.client.consume.AlbumClient;
import com.ruben.prueba.client.consume.PhotoClient;
import com.ruben.prueba.client.models.PhotoApi;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ApiServiceImpl implements ApiService {

    private AlbumClient albumClient;
    private PhotoClient photoClient;

    @Autowired
    public ApiServiceImpl(AlbumClient albumClient, PhotoClient photoClient) {
        this.albumClient = albumClient;
        this.photoClient = photoClient;
    }

    @Override
    public List<AlbumApi> getEnrichedAlbums(){
        log.info("retrieve albums with photos from an external API");
        return this.albumsWithPhotos();
    }

    private List<AlbumApi> albumsWithPhotos(){
        List<AlbumApi> albums = this.retrieveAlbums();
        //Agrupamos las photos en el id del album que le corresponde
        Map<Integer, List<PhotoApi>> photos = 
			this.retrievePhotos().stream().collect(Collectors.groupingBy(PhotoApi::getAlbumId));
        //Añadimos las listas de photos a los albunes correspondientes
        for (Map.Entry<Integer, List<PhotoApi>> entry : photos.entrySet()) {
            AlbumApi album = albums.get(entry.getKey()-1);
            album.setPhotos(entry.getValue());
        }
        return albums;
    }
    
    private List<AlbumApi> retrieveAlbums(){
        log.info("retrieve albunes");
        return albumClient.getAllAlbums();
    }

    private List<PhotoApi> retrievePhotos(){
        log.info("retrieve photos");
        return photoClient.getAllPhotos();
    }

    @Override
    public Optional<AlbumApi> getAlbumById(Long id){
        log.info("retrieve a photo by ID");

        
        return albumClient.getAlbumById(id);
    }



}
