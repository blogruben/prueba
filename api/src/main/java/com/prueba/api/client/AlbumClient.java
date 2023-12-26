package com.prueba.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.prueba.api.models.AlbumModel;


@FeignClient(name = "albumClient", url = "https://jsonplaceholder.typicode.com/albums/")
public interface AlbumClient {
    @GetMapping(value = "/{id}")
    AlbumModel getAlbumById(@PathVariable(value = "id") Integer id);

    @GetMapping(value = "/{id}")
    AlbumModel getAlbumByIdAndDynamicUrl(@PathVariable(name = "id") Integer id);
}
