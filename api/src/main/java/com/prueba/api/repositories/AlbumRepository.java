package com.prueba.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.prueba.api.models.AlbumModel;

@Repository
public interface AlbumRepository extends CrudRepository<AlbumModel, Long> {
}