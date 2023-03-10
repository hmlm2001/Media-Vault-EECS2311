package backendTests;

import backend.*;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MediaCollectionTest {

	MediaCollection user1Collection;
	MediaCollection user3Collection;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@BeforeEach
	void init() {
		UseStub.setStubFlag(true);
		user1Collection = new MediaCollection(1);
		user3Collection = new MediaCollection(3);
	}
	
	// Testing the addition of media
	@Test
	void addMediaTest1() throws ParseException {
		assertTrue(user1Collection.addMedia(new Movie(505642)));
	}

	// Testing the addition of duplicate media 
	@Test
	void addMediaTest2() throws ParseException {
		Movie med = new Movie(505642);
		user1Collection.addMedia(med);
		assertFalse(user1Collection.addMedia(med));
	}
	
	// Testing the removal of existing media
	@Test
	void removeMediaTest1() throws ParseException {
		Movie med = new Movie(505642);
		assertTrue(user1Collection.addMedia(med));
		assertTrue(user1Collection.removeMedia(505642));
	}
	
	// Testing the removal of non-existing media
	@Test
	void removeMediaTest2() throws ParseException {
		Movie med = new Movie(315162);
		assertFalse(user1Collection.removeMedia(315162));
	}	
	
	// Testing getMediaList
	@Test
	void getMediaListTest() throws ParseException {
		ArrayList<Media> user3list = new ArrayList<>();
		
		user3list= user3Collection.getMediaList();
		
		assertEquals(646389,user3list.get(0).getId());
		assertEquals(772515,user3list.get(1).getId());	
		
	
	}	

}
