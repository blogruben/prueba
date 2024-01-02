package com.ruben.prueba.client.consume;

import java.util.List;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.ruben.prueba.client.models.PhotoApi;


@FeignClient(name = "photoClient", url = "https://jsonplaceholder.typicode.com/photos/")
public interface PhotoClient {
    @GetMapping(value = "/{id}")
    Optional<PhotoClient> getPhotoById(@PathVariable(value = "id") Long id);

    @GetMapping()
    List<PhotoApi> getAllPhotos();
}


