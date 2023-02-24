package backendTests;

import backend.*;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MediaCollectionTest {

	MediaCollection medias;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@BeforeEach
	void init() {
		medias = new MediaCollection();
	}
	
	// Testing the addition of media
	@Test
	void addMediaTest1() throws ParseException {
		assertTrue(medias.addMedia(new Media("Test1", dateFormat.parse("2022-02-02"))));
	}

	// Testing the addition of duplicate media 
	@Test
	void addMediaTest2() throws ParseException {
		Media med = new Media("Test1", dateFormat.parse("2022-02-02"));
		medias.addMedia(med);
		assertFalse(medias.addMedia(med));
	}
	
	// Testing the removal of existing media
	@Test
	void removeMediaTest1() throws ParseException {
		Media med = new Media("Test1", dateFormat.parse("2022-02-02"));
		medias.addMedia(med);
		assertTrue(medias.removeMedia(med));
	}
	
	// Testing the removal of non-existing media
	@Test
	void removeMediaTest2() throws ParseException {
		Media med = new Media("Test1", dateFormat.parse("2022-02-02"));
		assertFalse(medias.removeMedia(med));
	}	
	
	// Testing getMediaList
	@Test
	void getMediaListTest() throws ParseException {
		ArrayList<Media> actual = new ArrayList<>();
		actual.add(new Media("Test1", dateFormat.parse("2022-02-02")));
		actual.add(new Media("Test2", dateFormat.parse("2022-02-02")));
		actual.add(new Media("Test3", dateFormat.parse("2022-02-02")));
		
		medias.addMedia(new Media("Test1", dateFormat.parse("2022-02-02")));
		medias.addMedia(new Media("Test2", dateFormat.parse("2022-02-02")));
		medias.addMedia(new Media("Test3", dateFormat.parse("2022-02-02")));
		assertEquals(actual.size(), medias.size());
	}	

}
