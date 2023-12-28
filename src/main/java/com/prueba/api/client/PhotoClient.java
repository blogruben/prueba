package com.prueba.api.client;

import java.util.List;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.prueba.api.models.Photo;


@FeignClient(name = "photoClient", url = "https://jsonplaceholder.typicode.com/photos/")
public interface PhotoClient {
    @GetMapping(value = "/{id}")
    Optional<Photo> getPhotoById(@PathVariable(value = "id") Long id);

    @GetMapping()
    List<Photo> getAllPhotos();
}
