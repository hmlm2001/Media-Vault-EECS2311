package persistenceTests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.Media;
import backend.Movie;
import backend.UseStub;
import persistence.JDBC_Connection;
import persistence.MediaCollectionDB;
import persistence.MovieDB;

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
	void getMediaCollectionIdTest() throws SQLException {
		int userid = 1;
		int collectionid = MediaCollectionDB.getMediaCollectionId(userid);
		
		assertEquals(1,collectionid);
				
	}
	/**
	 * Testing if getMediaCollectionId makes a new MediaCollection and returns the new MediaCollection id for a new user.
	 * @throws SQLException
	 */
	@Test
	void getMediaCollectionIdTest2() throws SQLException {
		int userid = 5;
		int collectionid = MediaCollectionDB.getMediaCollectionId(userid);
		
		assertEquals(5,collectionid);
				
	}
	
	/**
	 * Testing if the arraylist returned has all the corresponding movies to the collectionID in the database
	 * @throws SQLException
	 */
	@Test
	void getMediaCollectionTest1() throws SQLException {
		int userid = 1;
		int collectionid = MediaCollectionDB.getMediaCollectionId(userid);
		ArrayList<Media> collectionDB = MediaCollectionDB.getMediaCollection(collectionid);
		//TODO Make sure getMediaCollectionTest movie ids are up to date
		assertTrue(collectionDB.contains(new Movie(631842)));
		assertTrue(collectionDB.contains(new Movie(505642)));
	}
	/**
	 * Testing if the addMediaCollection adds media successfully
	 * @throws SQLException
	 */
	@Test
	void addMediaCollectionTest1() throws SQLException {
		//TODO Test addMediaCollectionTest
		int userid = 1;
		int collectionid = MediaCollectionDB.getMediaCollectionId(userid);
		Movie movie = new Movie(411);
		ArrayList<Media> collection = MediaCollectionDB.getMediaCollection(collectionid);
		assertFalse(collection.contains(movie));
		assertTrue(MediaCollectionDB.addMediaCollection(collectionid, 411));
		collection = MediaCollectionDB.getMediaCollection(collectionid);
		assertTrue(collection.contains(movie));
	}
	
	/**
	 * Testing when a movie is added to a collection containing that movie
	 * @throws SQLException
	 */
	@Test
	void addMediaCollectionTest2() throws SQLException{
		int userid = 1;
		int collectionid = MediaCollectionDB.getMediaCollectionId(userid);
		Movie movie = new Movie(411);
		ArrayList<Media> collection = MediaCollectionDB.getMediaCollection(collectionid);
		assertTrue(collection.contains(movie));
		assertFalse(MediaCollectionDB.addMediaCollection(collectionid, 411));
	}
	
	/**
	 * Testing if the removeMediaCollection removes media successfully
	 * @throws SQLException
	 */
	@Test
	void removeMediaCollectionTest1() throws SQLException {
		//TODO Test removeMediaCollectionTest
		int userid = 1;
		int collectionid = MediaCollectionDB.getMediaCollectionId(userid);
		Movie movie = new Movie(411);
		ArrayList<Media> collection = MediaCollectionDB.getMediaCollection(collectionid);
		assertTrue(collection.contains(movie));
		assertTrue(MediaCollectionDB.addMediaCollection(collectionid, 411));
		collection = MediaCollectionDB.getMediaCollection(collectionid);
		assertFalse(collection.contains(movie));
	}

	/**
	 * Testing when the removeMediaCollection removes media from a collection not containing the media initially
	 * @throws SQLException
	 */
	@Test
	void removeMediaCollectionTest2() throws SQLException {
		int userid = 1;
		int collectionid = MediaCollectionDB.getMediaCollectionId(userid);
		Movie movie = new Movie(411);
		ArrayList<Media> collection = MediaCollectionDB.getMediaCollection(collectionid);
		assertFalse(collection.contains(movie));
		assertFalse(MediaCollectionDB.addMediaCollection(collectionid, 411));
	}
}
