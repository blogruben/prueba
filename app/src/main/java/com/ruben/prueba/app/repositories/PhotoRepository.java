package com.ruben.prueba.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ruben.prueba.app.models.PhotoModel;

@Repository
public interface PhotoRepository extends CrudRepository<PhotoModel, Long> {
}

