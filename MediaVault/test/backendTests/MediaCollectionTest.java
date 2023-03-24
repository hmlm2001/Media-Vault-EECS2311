package backendTests;

import backend.*;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MediaCollectionTest {

	MediaCollection user1Collection;
	MediaCollection user3Collection;
	
	@BeforeEach
	void init() {
		UseStub.setStubFlag(true);
		user1Collection = new MediaCollection(1);
		user3Collection = new MediaCollection(3);
	}
	
	/**
	 * Testing the addition of media
	 * @throws ParseException
	 */
	@Test
	void addMediaTest1() throws ParseException {
		assertTrue(user1Collection.addMedia(new Movie(505642)));
	}

	/**
	 * Testing the addition of duplicate media 
	 * @throws ParseException
	 */
	@Test
	void addMediaTest2() throws ParseException {
		Movie med = new Movie(505642);
		user1Collection.addMedia(med);
		assertFalse(user1Collection.addMedia(med));
	}
	
	/**
	 *  Testing the removal of existing media
	 * @throws ParseException
	 */
	@Test
	void removeMediaTest1() throws ParseException {
		Movie med = new Movie(505642);
		assertTrue(user1Collection.addMedia(med));
		assertTrue(user1Collection.removeMedia(505642));
	}
	
	/**
	 *  Testing the removal of non-existing media
	 * @throws ParseException
	 */
	@Test
	void removeMediaTest2() throws ParseException {
		assertFalse(user1Collection.removeMedia(315162));
	}	
	
	/**
	 *  Testing getMediaList
	 * @throws ParseException
	 */
	@Test
	void getMediaListTest() throws ParseException {
		ArrayList<Media> user3list = new ArrayList<>();
		user3list = user3Collection.getMediaList();
		
		assertEquals(646389,user3list.get(0).getId());
		assertEquals(772515,user3list.get(1).getId());	
	}	
	
	/**
	 * Testing setStatus for existing media
	 */
	@Test 
	void setStatusTest() {
		assertTrue(user3Collection.setStatus(646389, "Completed"));
		assertTrue(user3Collection.setStatus(772515, "Yet to Watch"));
	}
	
	/**
	 * Testing setStatus for non-existing media
	 */
	@Test 
	void setStatusTest2() {
		assertFalse(user1Collection.setStatus(646389, "Completed"));
		assertFalse(user1Collection.setStatus(772515, "Yet to Watch"));
	}
	
	/**
	 * Testing size
	 */
	@Test
	void sizeTest() {
		assertEquals(1,user1Collection.size());
		assertEquals(2,user3Collection.size());
	}
	
	/**
	 * Testing getId
	 */
	@Test
	void getIdTest() {
		assertEquals(1,user1Collection.getId());
		assertEquals(3,user3Collection.getId());
	}
}
