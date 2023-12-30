package com.ruben.prueba.app.services;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ruben.prueba.app.models.AlbumModel;
import com.ruben.prueba.client.models.AlbumApi;

@Mapper
public interface MapearAlbums {

    //@Mapping(target="nombre", source="name")   
    //@Mapping(target="innerApellido.apellido_uno", source="innerSurname.first")     
    //@Mapping(target="innerApellido.apellido_dos", source="innerSurname.second")   
    AlbumModel mapear(AlbumApi albumApi);
   
} 
