package com.ruben.prueba.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ruben.prueba.app.models.AlbumModel;
import com.ruben.prueba.app.services.AlbumService;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class UnitTests {

  	@Autowired
  	private AlbumService albumService;

	@Test
    void givenAlbumsFromAPI_whengetAll_thenAlbumSizeIs100() {
		List<AlbumModel> albumModel = albumService.getAllAlbumsFromApi();
		assertEquals(100, albumModel.size());
		assertEquals(50, albumModel.get(2).getPhotos().size());
    }

	@Test
	void givenAlbumsFromAPI_whengetById_thenOkay() {
		AlbumModel album = AlbumModel.builder()
		.userId(1)
		.title("quidem molestiae enim")
		.build();
		assertEquals(album, albumService.getAlbumByIdFromApi(1L));
	}

	@Test
	void givenAlbumFromDB_whengetFromDB_thenOkay() {
		albumService.saveAllAlbumsFromAPIintoDB();
		Optional<AlbumModel> oAlbum = albumService.getAlbumByIdFromDb(1L);
		assertEquals("quidem molestiae enim",oAlbum.get().getTitle());
	}

	@Test
	void givenAlbumFromDB_whengetALbumNotExit_thenReturnNull() {
		albumService.saveAllAlbumsFromAPIintoDB();
		Optional<AlbumModel> oAlbum = albumService.getAlbumByIdFromDb(10000000L);
		assertFalse(oAlbum.isPresent());
	}


}
