package test.backendTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import backend.Media;

class MediaTest {

	@Test
	void getNameTest1() {
		Media med = new Media("name", new Date("2023-02-03"));
		assertEquals("name",med.getName());
	}
	@Test	
	void getNameTest2() {
		Date date = new Date("2023-02-03");
		Media med = new Media("name", date);
		assertEquals(date, med.getReleaseDate());
	}	

}
