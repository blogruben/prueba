package com.prueba.api.client;

import org.springframework.stereotype.Repository;
import com.prueba.api.models.Album;

@Repository
public interface AlbumDelivery {
    Album getAllAlbums();
}
