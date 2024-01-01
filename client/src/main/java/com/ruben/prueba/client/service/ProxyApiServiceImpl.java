package com.ruben.prueba.client.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.ruben.prueba.client.models.AlbumApi;

@Service
public class ProxyApiServiceImpl implements ApiService {

    private ApiService apiService;
    List<AlbumApi> albumApiList;
    private int numeroLecturas;

    @Value("${spring.cache.refrest_times}")
    private static int cacheNumeroLecturasTotal;

    @Autowired
    public ProxyApiServiceImpl(ApiService apiService) {
        this.apiService = apiService;
        this.numeroLecturas = 0;
    }

    @Override
    public List<AlbumApi> getEnrichedAlbums() {
        if(numeroLecturas == cacheNumeroLecturasTotal || albumApiList==null){
            numeroLecturas = 0;
            this.albumApiList = apiService.getEnrichedAlbums();
        }
        numeroLecturas++;
        return List.copyOf(this.albumApiList);
    }

    @Override
    public Optional<AlbumApi> getAlbumById(Long id) {
        return apiService.getAlbumById(id);
    }

}
