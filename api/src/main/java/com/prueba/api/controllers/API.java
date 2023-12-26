package com.prueba.api.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.api.models.Album;
import com.prueba.api.services.ApiService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
//@RequestMapping("/API") @ResponseBody
public class API   {
  
  ApiService apiService;

  @Autowired
  public API(ApiService apiService) {
    this.apiService = apiService;
  }
    
  @GetMapping("/api/albums")
  public List<Album> getAllAlbumsFromAPI() {
    log.info("endpoint /API/albums");
    return this.apiService.enrichAlbums();
  }

  @GetMapping(path ="/api/albums/{id}")
  public Optional<Album> getAlbumById(@PathVariable("id") Long id) {
    log.info("endpoint /api/album/{id}");
    return this.apiService.getAlbumById(id);
  }


}
