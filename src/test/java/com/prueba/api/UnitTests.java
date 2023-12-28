package com.prueba.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.api.models.Album;
import com.prueba.api.services.ApiService;
import com.prueba.api.services.DbService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


@SpringBootTest
class UnitTests {

  	@Autowired
  	private ApiService apiService;

  	@Autowired
  	private DbService dbService;


	@Test
    void givenAlbumsFromAPI_whengetAll_thenAlbumSizeIs100() {
      assertEquals(100,apiService.retrieveAlbums().size());
    }

  	@Test
    void givenPhotosFromAPI_whengetAll_thenAlbumSizeIs100() {
      assertEquals(5000,apiService.retrievePhotos().size());
    }

	@Test
	void givenAlbumsFromAPI_whengetById_thenOkay() {
		Album album = Album.builder()
		.userId(1)
		.title("quidem molestiae enim")
		.build();
		assertEquals(album, apiService.getAlbumById(1L));
	}


	@Test
	void givenAlbumFromAPI_whenSaveIntoDB_thenOkay() {

		dbService.saveAllAlbumsFromAPIintoDB();
		List<Album> albums = dbService.retrieveAlbums();

		assertEquals(100,albums.size());
		assertEquals(50,albums.get(0).getPhotos().size());

		//assert primer elemento 
	}


}
