package persistenceTests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import backend.Media;
import backend.UseStub;
import persistence.MediaCollectionDB;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MediaCollectionDBTest {


	@BeforeEach
	void init() {
		UseStub.setStubFlag(false);
	}
	/**
	 * Testing if getMediaCollectionId returns the correct MediaCollection id
	 * @throws SQLException
	 */	
	@Test
	@Order(1)
	void getMediaCollectionIdTest1() throws SQLException {
		int userid = 1;
		int collectionid = MediaCollectionDB.getMediaCollectionId(userid);
		
		assertEquals(1,collectionid);
				
	}
	/**
	 * Testing if getMediaCollectionId makes a new MediaCollection and returns the new MediaCollection id for a new user.
	 * @throws SQLException
	 */
	@Test
	@Order(2)
	void getMediaCollectionIdTest2() throws SQLException {
		int userid = 5;
		int collectionid = MediaCollectionDB.getMediaCollectionId(userid);
		
		assertEquals(5,collectionid);
		System.out.println("This test only passes on the first run since a new mediaCollectionId is initially created for the userId.");
	}
	
	/**
	 * Testing if the arraylist returned has all the corresponding movies to the collectionID in the database
	 * @throws SQLException
	 */
	@Test
	@Order(3)
	void getMediaCollectionTest() throws SQLException {
		int userid = 4;
		int collectionid = MediaCollectionDB.getMediaCollectionId(userid);
		ArrayList<Media> collectionDB = MediaCollectionDB.getMediaCollection(collectionid);
		assertEquals(631842, collectionDB.get(0).getId());
		assertEquals(19995, collectionDB.get(1).getId());
		assertEquals(2, collectionDB.size());
	}
	
	/**
	 * Testing if the addMediaCollection adds media successfully
	 * @throws SQLException
	 */
	@Test
	@Order(4)
	void addMediaCollectionTest1() throws SQLException {
		int userid = 1;
		int collectionid = MediaCollectionDB.getMediaCollectionId(userid);
		ArrayList<Media> collectionDB = MediaCollectionDB.getMediaCollection(collectionid);
		MediaCollectionDB.addMediaCollection(collectionid, 836988);
		assertTrue(collectionDB.size() < MediaCollectionDB.getMediaCollection(collectionid).size());
		System.out.println("This test only passes on the first run since media is intially added to the media collection.");
	}
	
	/**
	 * Testing when a movie is added to a collection containing that movie
	 * @throws SQLException
	 */
	@Test
	@Order(5)
	void addMediaCollectionTest2() throws SQLException{
		int userid = 1;
		int collectionid = MediaCollectionDB.getMediaCollectionId(userid);
		assertFalse(MediaCollectionDB.addMediaCollection(collectionid, 631842));
	}

	/**
	 * Testing if the removeMediaCollection removes media successfully
	 * @throws SQLException
	 */
	@Test
	@Order(6)
	void removeMediaCollectionTest1() throws SQLException {
		int userid = 1;
		int collectionid = MediaCollectionDB.getMediaCollectionId(userid);
		ArrayList<Media> collectionDB = MediaCollectionDB.getMediaCollection(collectionid);
		MediaCollectionDB.removeMediaCollection(collectionid, 32516);
		assertTrue(collectionDB.size() > MediaCollectionDB.getMediaCollection(collectionid).size());
		System.out.println("This test only passes on the first run since the movie is initially removed from the media collection.");
	}
	
	/**
	 * Testing when the removeMediaCollection removes media from a collection not containing the media initially
	 * @throws SQLException
	 */
	@Test
	@Order(7)
	void removeMediaCollectionTest2() throws SQLException {
		int userid = 1;
		int collectionid = MediaCollectionDB.getMediaCollectionId(userid);
		assertFalse(MediaCollectionDB.removeMediaCollection(collectionid, 411));
	}

}
