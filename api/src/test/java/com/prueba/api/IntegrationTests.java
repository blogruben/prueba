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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void givenAlbum_whenGet_thenOkay() throws Exception {
			mockMvc.perform(get("/photo").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string("[]"))
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

	@Test
	void givenAlbum_whenSave_thenOkay() throws Exception {
			mockMvc.perform(post("/photo")
			.content("{ \"albumId\": 1, \"title\": \"TITLE222\", \"url\": \"URL\", \"thumbnailUrl\": \"THUMBNAIL_URL\" }")
			.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("[{ \\\"albumId\\\": 1, \\\"title\\\": \\\"TITLE222\\\", \\\"url\\\": \\\"URL\\\", \\\"thumbnailUrl\\\": \\\"THUMBNAIL_URL\\\" }]"))
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

	@Test
	void givenApiRest_whenSendWrongURL_thenKo() throws Exception {
			mockMvc.perform(get("/wrongPath")
			.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}

	@Test
	void givenApiRest_whenSendWrongParam_thenKo() throws Exception {
			mockMvc.perform(get("/photo/a")
			.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}
}

