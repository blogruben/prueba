package com.prueba.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.api.models.PhotoModel;
import com.prueba.api.services.PhotoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/photo")
public class PhotoController {
   @Autowired
   PhotoService photoService;

   @GetMapping()
   public ArrayList<PhotoModel> getAllPhotos(){
    return this.photoService.getAllPhotos();
   }
    
   @PostMapping()
   public List<PhotoModel> savePhoto(@RequestBody ArrayList<PhotoModel> photoList){
    return this.photoService.savePhotoList(photoList);
   }

   //Ejemlo http://localhost:8080/photo/1
   @GetMapping(path ="/{id}")
   public Optional<PhotoModel> getPhotoById(@PathVariable("id") Long id){
    log.info("Receive GET  endpoint: /photo/{}",id);
    Optional<PhotoModel> oPhoto = this.photoService.obtenerPhotosPorId(id);
    if (oPhoto.isPresent()) {
      log.info("el tostring es: "+oPhoto.get().toString());
      log.info("el titulo es: "+oPhoto.get().getTitle());
    }
    return oPhoto;
   }


  @DeleteMapping(path ="/{id}")
  public String deleteById(@PathVariable("id") Long id){
    boolean ok = this.photoService.deletePhoto(id);
    if(ok){
      return "Se elimino la photo por id "+id;
    }else{
      return "No se pudo eliminar el usuario con id "+id;
    }
  }







}
