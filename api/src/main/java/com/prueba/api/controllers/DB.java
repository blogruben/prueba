package com.prueba.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.api.models.Album;
import com.prueba.api.services.AlbumService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/DB")
public class DB {

  AlbumService albumService;

  @Autowired
  public DB(AlbumService albumService) {
    this.albumService = albumService;
  }

  @GetMapping(value = "/albums")
  public List<Album> getAllAlbums() {
    log.info("endpoint /DB/albums");
    return this.albumService.obtenerAlbums();
  }

  @GetMapping(value ="/album/{id}")
  public Optional<Album> getAlbumById(@PathVariable("id") Long id) {
    log.info("endpoint /DB/albums/{id}");
    return this.albumService.getAlbumById(id);
  }

  @PutMapping(value = "/albums")
  public String saveAllAlbumsFromAPIintoDB() {
    log.info("endpoint /DB/albums");
      return "";
  }

}
