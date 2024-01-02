package com.ruben.prueba.app.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruben.prueba.app.models.AlbumModel;
import com.ruben.prueba.app.services.AlbumService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/albums")
public class AlbumController   {
  
  AlbumService albumsService;

  @Autowired
  public AlbumController(AlbumService albumsService) {
    this.albumsService = albumsService;
  }
    
  @GetMapping("/api")
  public List<AlbumModel> getAllAlbumsFromAPI() {
    log.info("endpoint /API/albums");
    return this.albumsService.getAllAlbumsFromApi();
  }
  
  @GetMapping(path ="/api/{id}")
  public AlbumModel getAlbumByIdfromApi(@PathVariable("id") Long id) {
    log.info("endpoint /api/album/{id}");
    return this.albumsService.getAlbumByIdFromApi(id);
  }

  @GetMapping(value = "/db")
  public List<AlbumModel> getAllAlbumsFromDb() {
    log.info("endpoint /DB/albums");
    return this.albumsService.getAllAlbumsFromDB();
  }

  @GetMapping(value ="/db/{id}")
  public Optional<AlbumModel> getAlbumByIdFromDB(@PathVariable("id") Long id) {
    log.info("endpoint /DB/albums/{id}");
    return this.albumsService.getAlbumByIdFromDb(id);
  }

  @PutMapping(value = "/db")
  public String saveAllAlbumsFromAPIintoDB() {
    log.info("endpoint /DB/albums");
    return this.albumsService.saveAllAlbumsFromAPIintoDB();
  }

}
