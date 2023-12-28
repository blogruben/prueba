package com.prueba.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void givenAlbumFromAPI_whenGet_thenOkay() throws Exception {
			mockMvc.perform(get("/api/albums/1").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json("{\"id\":1,\"userId\":1,\"title\":\"quidem molestiae enim\",\"photos\":null}"))
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));	
	}


	@Test
	void givenNonExistenAlbumFromAPI_whenGet_thenKo() throws Exception {
			mockMvc.perform(get("/api/albums/100000000").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound());	
	}

	@Test
	void givenAlbum_whenSave_thenOkay() throws Exception {
			mockMvc.perform(get("/api/albums").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}


}
