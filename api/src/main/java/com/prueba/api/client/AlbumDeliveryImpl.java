package com.prueba.api.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.prueba.api.models.AlbumModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlbumDeliveryImpl extends AbstractClient implements AlbumDelivery{

    @Override
    public AlbumModel getAllAlbums() {
		String url = baseUrl + "/albums";//"https://jsonplaceholder.typicode.com/albums";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AlbumModel[]> responseEntity = restTemplate.getForEntity(url, AlbumModel[].class);

		log.info("Status Code: " + responseEntity.getStatusCode());
		for (AlbumModel e : responseEntity.getBody()) {
			log.info(e.toString());
		}
        return null;
    }
}
