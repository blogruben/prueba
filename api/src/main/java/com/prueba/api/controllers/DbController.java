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
import com.prueba.api.services.DbService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/db")
public class DbController {

  DbService dbService;

  @Autowired
  public DbController(DbService dbService) {
    this.dbService = dbService;
  }

  @GetMapping(value = "/albums")
  public List<Album> getAllAlbums() {
    log.info("endpoint /DB/albums");
    return this.dbService.obtenerAlbums();
  }

  @GetMapping(value ="/albums/{id}")
  public Optional<Album> getAlbumById(@PathVariable("id") Long id) {
    log.info("endpoint /DB/albums/{id}");
    return this.dbService.getAlbumById(id);
  }

  @PutMapping(value = "/albums")
  public String saveAllAlbumsFromAPIintoDB() {
    log.info("endpoint /DB/albums");
    return this.dbService.saveAllAlbumsFromAPIintoDB();
  }

}
