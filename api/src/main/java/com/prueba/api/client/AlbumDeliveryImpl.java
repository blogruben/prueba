package com.prueba.api.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.prueba.api.models.Album;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlbumDeliveryImpl extends AbstractClient implements AlbumDelivery{

    @Override
    public Album getAllAlbums() {
		String url = baseUrl + "/albums";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Album[]> responseEntity = restTemplate.getForEntity(url, Album[].class);

		log.info("Status Code: " + responseEntity.getStatusCode());
		for (Album e : responseEntity.getBody()) {
			log.info(e.toString());
		}
        return null;
    }
}
