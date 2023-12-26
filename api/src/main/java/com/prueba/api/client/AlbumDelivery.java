package com.prueba.api.client;

import org.springframework.stereotype.Repository;
import com.prueba.api.models.AlbumModel;

@Repository
public interface AlbumDelivery {
    AlbumModel getAllAlbums();
}
