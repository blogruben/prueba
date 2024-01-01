package com.ruben.prueba.app.services;

import org.mapstruct.Mapper;
import com.ruben.prueba.app.models.AlbumModel;
import com.ruben.prueba.client.models.AlbumApi;

@Mapper
public interface MapearAlbums {
 
    AlbumModel mapear(AlbumApi albumApi);
    
} 

