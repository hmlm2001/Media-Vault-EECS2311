package test.backend;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;

import backend.*;

class AllMediaTest {

	AllMedia allMedia;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@BeforeEach
	void init() {
		allMedia = new AllMedia();
	}
	
	// Test initialization
	@Test
	void allMediaTest() {
		assertTrue(allMedia != null);
	}
	
	/*
	 * //Test that all keys and all values are one-to-one
	 * 
	 * @Test void AllMediaTest2() { assertTrue(allMedia != null);
	 * assertTrue(allMedia.MediaMap != null); assertFalse(allMedia.MediaMap.size ==
	 * 0); assertFalse(allMedia.MediaMap.values().isEmpty());
	 * assertEquals(allMedia.MediaMap.keySet().size(),
	 * allMedia.MediaMap.values().size()); }
	 */
	
	// Test search for existing element's name
	@Test
	void searchMediaTest1() throws java.lang.Exception {
		Media expected = new Media("se7en", dateFormat.parse("1995-09-22"));
		Media actual = allMedia.searchMedia("Se7en");
		assertEquals(expected.getName(), actual.getName());
	}
	
	// Test search for existing element's release date
	@Test
	void searchMediaTest2() throws java.lang.Exception {
		Media expected = new Media("Inception", dateFormat.parse("2010-07-16"));
		Media actual = allMedia.searchMedia("Inception");
		assertEquals(expected.getReleaseDate(), actual.getReleaseDate());
	}
	
	// Test search for nonexisting element
	void searchMediaTest3() {
		assertThrows(Exception.class, ()-> allMedia.searchMedia("How To Train Your Dragon"));
	}

}
