package com.prueba.api.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.api.models.AlbumModel;
import com.prueba.api.repositories.AlbumRepository;


@Service
public class AlbumService {
    @Autowired
    AlbumRepository albumRepository;


    public ArrayList<AlbumModel> obtenerAlbums(){
        return (ArrayList<AlbumModel>) albumRepository.findAll();
    }

    public AlbumModel saveAlbum(AlbumModel album){
        return albumRepository.save(album);
    }

    public Optional<AlbumModel> getAlbumById(Long id){
        return albumRepository.findById(id);
    }

    public boolean deleteAlbum(Long id){
        try{
            albumRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
        
    }
}
