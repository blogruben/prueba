package com.prueba.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UnitTests {

	@Test
	void givenAlbum_whenSave_thenOkay() {
		assertNotNull("NOT NULL");
		assertNotEquals("John", "Duke");
		assertThrows(NumberFormatException.class, () -> Integer.valueOf("duke"));
		assertEquals("hello world", "HELLO WORLD".toLowerCase());
		assertEquals(1, 2);

	}

	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({
			"0,    1,   1",  //probamos el cero
			"1,    0,   1",
			"-1,   1,   0",  //probamos numeros negativos
			"-1,  -2,  -3",  
			"1,    3,   4",  //pruebas standard
			"49, s 51, 100",

	})
	void add(int first, int second, int expectedResult) {
		
		assertEquals(expectedResult, first + second,
				() -> first + " + " + second + " should equal " + expectedResult);
	}

}
