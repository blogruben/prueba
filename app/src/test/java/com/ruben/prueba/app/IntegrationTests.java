package com.ruben.prueba.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;


@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void givenAlbumFromAPI_whenGetOne_thenOkay() throws Exception {
			mockMvc.perform(get("/albums/api/1").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json("{\"id\":1,\"userId\":1,\"title\":\"quidem molestiae enim\",\"photos\":null}"))
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));	
	}

	@Test
	void givenAlbumFromAPIa_whenGetAll_thenOkay() throws Exception {
			mockMvc.perform(get("/albums/api").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.length()").value(100))
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));	
	}

	@Test
	void givenAlbums_whensaveAlbum_thenReturnedAlbumsAre100() throws Exception {
			mockMvc.perform(put("/albums/db").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

			mockMvc.perform(get("/albums/db").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.length()").value(100));
	}



}

