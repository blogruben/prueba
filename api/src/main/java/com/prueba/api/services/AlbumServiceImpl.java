package com.prueba.api.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.api.client.AlbumClient;
import com.prueba.api.models.Album;
import com.prueba.api.repositories.AlbumRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AlbumServiceImpl implements AlbumService {


    private AlbumRepository albumRepository;
    private AlbumClient albumClient;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository, AlbumClient albumClient) {
        this.albumRepository = albumRepository;
        this.albumClient = albumClient;
    }

    @Override
    public ArrayList<Album> obtenerAlbums(){
        log.info("PRUEBA XXXXXXXXXXXXXXXXXXXXXXX");
        //log.info(albumClient.getAlbumById(2).toString());
        return (ArrayList<Album>) albumRepository.findAll();
    }

    @Override
    public Album saveAlbum(Album album){
        return albumRepository.save(album);
    }

    @Override
    public Optional<Album> getAlbumById(Long id){
        return albumRepository.findById(id);
    }

    @Override
    public boolean deleteAlbum(Long id){
        try{
            albumRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
        
    }
}
