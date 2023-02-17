package test.backendTest;

import backend.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class MediaCollectionTest {

	@SuppressWarnings("deprecation")
	@Test
	void addMediaTest1() {
		MediaCollection medias = new MediaCollection();
		assertTrue(medias.addMedia(new Media("Test1", new Date("2022-02-02"))));
	}
	@SuppressWarnings("deprecation")
	@Test
	void addMediaTest2() {
		MediaCollection medias = new MediaCollection();
		medias.addMedia(new Media("Test1", new Date("2022-02-02")));
		assertFalse(medias.addMedia(new Media("Test1", new Date("2022-02-02"))));
	}
	@Test
	void removeMediaTest1() {
		MediaCollection medias = new MediaCollection();
		Media med = new Media("Test1", new Date("2022-02-02"));
		medias.addMedia(med);
		assertTrue(medias.removeMedia(med));
	}
	@Test
	void removeMediaTest2() {
		MediaCollection medias = new MediaCollection();
		Media med = new Media("Test1", new Date("2022-02-02"));
		assertFalse(medias.removeMedia(med));
	}	

}
