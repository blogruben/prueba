package com.ruben.prueba.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ruben.prueba.client.models.AlbumApi;
import com.ruben.prueba.client.service.ApiService;

@SpringBootTest
class UnitTests {

  @Autowired
  private ApiService proxyApiServiceImpl;

	@Test
  void whenGetAlbum_thenOkay() {
    // When
    AlbumApi albumApi = proxyApiServiceImpl.getAlbumById(1L).get();
    // Then
    AlbumApi album = new AlbumApi();
	  album.setUserId(1);
	  album.setTitle("quidem molestiae enim");
    assertEquals(album, albumApi); 
  }

	@Test
  void whenEnrichAlbums_thenOkay() {
    // When
    List<AlbumApi> albums = proxyApiServiceImpl.getEnrichedAlbums();
    // Then
    assertEquals(100, albums.size());
    assertEquals(50, albums.get(2).getPhotos().size());
  }

	@Test
  void whenEnrichAlbum_thenOkay() {
    // When
    List<AlbumApi> albums = proxyApiServiceImpl.getEnrichedAlbums();
    // Then
    String actual = albums.get(0).getPhotos().get(0).toString();
    String expected = "PhotoApi(albumId=1, title=accusamus beatae ad facilis cum similique qui sunt, url=https://via.placeholder.com/600/92c952, thumbnailUrl=https://via.placeholder.com/150/92c952)";
    assertEquals(expected, actual);
  }

	@Test
  void whenEquals_thenOkay() {
    // When
    AlbumApi albumApi = proxyApiServiceImpl.getAlbumById(1L).get();
    AlbumApi album = new AlbumApi();
	  album.setUserId(1);
	  album.setTitle("quidem molestiae enim");
    // Then
    assertEquals(album, albumApi);
  }

  

}
