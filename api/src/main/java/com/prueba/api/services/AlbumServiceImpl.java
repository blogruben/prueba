package com.prueba.api.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.api.client.AlbumClient;
import com.prueba.api.models.AlbumModel;
import com.prueba.api.repositories.AlbumRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumRepository albumRepository;
    
    @Autowired
    private AlbumClient albumClient;


    @Override
    public ArrayList<AlbumModel> obtenerAlbums(){
        log.info("PRUEBA XXXXXXXXXXXXXXXXXXXXXXX");
        log.info(albumClient.getAlbumById(2).toString());
        return (ArrayList<AlbumModel>) albumRepository.findAll();
    }

    @Override
    public AlbumModel saveAlbum(AlbumModel album){
        return albumRepository.save(album);
    }

    @Override
    public Optional<AlbumModel> getAlbumById(Long id){
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
