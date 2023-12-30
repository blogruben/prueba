package com.ruben.prueba.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ruben.prueba.client.models.AlbumApi;
import com.ruben.prueba.client.service.ApiService;

@SpringBootTest
class UnitariosTests {

  @Autowired
  private ApiService apiService;

	@Test
  void test1() {
    AlbumApi albumApi = apiService.getAlbumById(1L).get();
      AlbumApi album = AlbumApi.builder()
		  .userId(1)
		  .title("quidem molestiae enim")
		  .build();
      assertEquals(album, albumApi);
  }

	@Test
  void test2() {
      List<AlbumApi> albums = apiService.getEnrichedAlbums();
      assertEquals(100, albums.size());
      assertEquals(50, albums.get(2).getPhotos().size());
    }

}
