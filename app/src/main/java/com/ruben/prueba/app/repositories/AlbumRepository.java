package com.ruben.prueba.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ruben.prueba.app.models.AlbumModel;

@Repository
public interface AlbumRepository extends CrudRepository<AlbumModel, Long> {
}