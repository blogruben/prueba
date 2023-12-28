package com.prueba.api.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.prueba.api.client.AlbumClient;
import com.prueba.api.client.PhotoClient;
import com.prueba.api.models.Album;
import com.prueba.api.models.Photo;
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
    public List<Album> enrichAlbums(){
        log.info("retrieve albums with photos from an external API");
        return this.albumsWithPhotos();
    }

    private List<Album> albumsWithPhotos(){
        List<Album> albums = this.retrieveAlbums();
        //Agrupamos las photos en el id del album que le corresponde
        Map<Integer, List<Photo>> photos = 
			this.retrievePhotos().stream().collect(Collectors.groupingBy(Photo::getAlbumId));
        //Añadimos las listas de photos a los albunes correspondientes
        for (Map.Entry<Integer, List<Photo>> entry : photos.entrySet()) {
            Album album = albums.get(entry.getKey()-1);
            album.setPhotos(entry.getValue());
        }
        return albums;
    }
    
    @Override
    public List<Album> retrieveAlbums(){
        log.info("retrieve photos from an external API");
        return albumClient.getAllAlbums();
    }

    @Override
    public List<Photo> retrievePhotos(){
        log.info("retrieve photos from an external API");
        return photoClient.getAllPhotos();
    }

    @Override
    public Album getAlbumById(Long id){
        log.info("retrieve a photo by ID");
        Optional<Album> album = Optional.empty();;
        try {
            album = albumClient.getAlbumById(id);
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return album.get();
    }



}
