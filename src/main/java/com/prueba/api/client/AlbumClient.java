package com.prueba.api.client;

import java.util.List;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.prueba.api.models.Album;


@FeignClient(name = "albumClient", url = "https://jsonplaceholder.typicode.com/albums/")
public interface AlbumClient {

    @GetMapping(value = "/{id}")
    Optional<Album> getAlbumById(@PathVariable(value = "id") Long id);

    @GetMapping()
    List<Album> getAllAlbums();
}
