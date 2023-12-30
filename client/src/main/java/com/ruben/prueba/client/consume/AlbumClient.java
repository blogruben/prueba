package com.ruben.prueba.client.consume;

import java.util.List;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ruben.prueba.client.models.AlbumApi;


@FeignClient(name = "albumClient", url = "https://jsonplaceholder.typicode.com/albums/")
public interface AlbumClient {

    @GetMapping(value = "/{id}")
    Optional<AlbumApi> getAlbumById(@PathVariable(value = "id") Long id);

    @GetMapping()
    List<AlbumApi> getAllAlbums();
}
