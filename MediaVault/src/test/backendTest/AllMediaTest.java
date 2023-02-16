package test.backendTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.*;

class AllMediaTest {

	AllMedia allMedia;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@BeforeEach
	void init() {
		allMedia = new AllMedia();
	}
	
	//Test initialization
	@Test
	void AllMediaTest1() {
		assertTrue(allMedia != null);
		assertTrue(allMedia.MediaMap != null);
		assertFalse(allMedia.MediaMap.size == 0);
		assertFalse(allMedia.MediaMap.isEmpty());
	}
	
	//Test that all keys and all values are one-to-one
	@Test
	void AllMediaTest2() {
		assertTrue(allMedia != null);
		assertTrue(allMedia.MediaMap != null);
		assertFalse(allMedia.MediaMap.size == 0);
		assertFalse(allMedia.MediaMap.values().isEmpty());
		assertEquals(allMedia.MediaMap.keySet().size(), allMedia.MediaMap.values().size());
	}
	
	//Test search for existing element
	@Test
	void AllMediaTest3() {
		assertTrue(allMedia != null);
		assertTrue(allMedia.MediaMap != null);
		assertFalse(allMedia.MediaMap.size == 0);
		assertFalse(allMedia.MediaMap.values().isEmpty());
		assertDoesNotThrow(allMedia.searchMedia("Se7en"));
		Media media = allMedia.searchMedia("Se7en");
		assertEquals(media.name, "Se7en");
		assertEquals(media.releaseDate, dateFormat.parse("1995-09-22"));
	}
	
	//Test search for nonexisting element
	void AllMediaTest4() {
		assertTrue(allMedia != null);
		assertTrue(allMedia.MediaMap != null);
		assertFalse(allMedia.MediaMap.size == 0);
		assertFalse(allMedia.MediaMap.values().isEmpty());
		//TODO Create "SearchNotFoundException"
		//assertThrows(SearchNotFoundException.class, ()-> allMedia.searchMedia("How To Train Your Dragon"));
	}

}
