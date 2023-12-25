package com.prueba.api.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.api.models.AlbumModel;
import com.prueba.api.services.AlbumService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/album")
public class AlbumController   {
   @Autowired
   AlbumService albumService;

   @GetMapping()
   public ArrayList<AlbumModel> getAllAlbums(){
    return this.albumService.obtenerAlbums();
   }
    
   @PostMapping()
   public AlbumModel deleteAlbum(@RequestBody AlbumModel usuario){
    return this.albumService.saveAlbum(usuario);
   }

   //Ejemlo http://localhost:8080/album/1
   @GetMapping(path ="/{id}")
   public Optional<AlbumModel> getAlbumById(@PathVariable("id") Long id){
    //log.info("Buscar Album por id {id}",id);
    log.info("Buscar Album por id");
    return this.albumService.getAlbumById(id);
   }

  @DeleteMapping(path ="/{id}")
  public String deleteById(@PathVariable("id") Long id){
    boolean ok = this.albumService.deleteAlbum(id);
    if(ok){
      return "Deleted album "+id;
    }else{
      return "The album could not be deleted "+id;
    }

  }

}
