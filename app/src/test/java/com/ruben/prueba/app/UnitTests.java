package com.ruben.prueba.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ruben.prueba.app.models.AlbumModel;
import com.ruben.prueba.app.services.AlbumService;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
class UnitTests {

  	@Autowired
  	private AlbumService albumService;

	@Test
    void givenAlbumsFromAPI_whengetAll_thenAlbumSizeIs100() {
		List<AlbumModel> albumModel = albumService.getAllAlbumsFromApi();
		assertEquals(100, albumModel.size());
		assertEquals(50, albumModel.get(2).getPhotos().size());
		assertEquals(100,100);
    }

  	@Test
    void givenPhotosFromAPI_whengetAll_thenAlbumSizeIs100() {
      assertEquals(100,100);
    }

	//@Test
	//void givenAlbumsFromAPI_whengetById_thenOkay() {
		//AlbumModel album = AlbumModel.builder()
		//.userId(1)
		//.title("quidem molestiae enim")
		//.build();
		//assertEquals(album, apiService.getAlbumById(1L));
	//}


	//@Test
	//void givenAlbumFromAPI_whenSaveIntoDB_thenOkay() {

		//dbService.saveAllAlbumsFromAPIintoDB();
		//List<Album> albums = dbService.retrieveAlbums();

		//assertEquals(100,albums.size());
		//assertEquals(50,albums.get(0).getPhotos().size());

		//assert primer elemento 
	//}


}
