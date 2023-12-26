package com.prueba.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.prueba.api.models.Photo;

@Repository
public interface PhotoRepository extends CrudRepository<Photo, Long> {
}

