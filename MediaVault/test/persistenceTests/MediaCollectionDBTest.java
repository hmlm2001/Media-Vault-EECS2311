package persistenceTests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import backend.Media;
import backend.Movie;
import backend.UseStub;
import persistence.JDBC_Connection;
import persistence.MediaCollectionDB;
import persistence.MovieDB;

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
				
	}
	
	/**
	 * Testing if the arraylist returned has all the corresponding movies to the collectionID in the database
	 * @throws SQLException
	 */
	@Test
	@Order(3)
	void getMediaCollectionTest1() throws SQLException {
		int userid = 1;
		int collectionid = MediaCollectionDB.getMediaCollectionId(userid);
		ArrayList<Media> collectionDB = MediaCollectionDB.getMediaCollection(collectionid);
		//TODO Make sure getMediaCollectionTest movie ids are up to date
		assertEquals(631842,collectionDB.get(0).getId());
		assertEquals(505642,collectionDB.get(1).getId());
		assertEquals(2, collectionDB.size());
	}
	
	/**
	 * Testing if the addMediaCollection adds media successfully
	 * @throws SQLException
	 */
	@Test
	@Order(4)
	void addMediaCollectionTest1() throws SQLException {
		//TODO Test addMediaCollectionTest
		int userid = 1;
		int collectionid = MediaCollectionDB.getMediaCollectionId(userid);
		Movie movie = new Movie(411);
		ArrayList<Media> collection = MediaCollectionDB.getMediaCollection(collectionid);
		
		for(Media m: collection) {
			assertFalse(m.getId() == 411);			
		}
		
		assertTrue(MediaCollectionDB.addMediaCollection(collectionid, 411));
		
		
		int count = 0;
		collection = MediaCollectionDB.getMediaCollection(collectionid);
		for(Media m: collection) {
			if(m.getId() == 411)
				count++;
			}
		assertEquals(1,count);
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
		Movie movie = new Movie(411);
		ArrayList<Media> collection = MediaCollectionDB.getMediaCollection(collectionid);
		int count = 0;
		for(Media m: collection) {
			if(m.getId() == 411)
				count++;
			}
		assertEquals(1,count);
		assertFalse(MediaCollectionDB.addMediaCollection(collectionid, 411));
	}

	/**
	 * Testing if the removeMediaCollection removes media successfully
	 * @throws SQLException
	 */
	@Test
	@Order(6)
	void removeMediaCollectionTest1() throws SQLException {
		//TODO Test removeMediaCollectionTest
		int userid = 1;
		int collectionid = MediaCollectionDB.getMediaCollectionId(userid);
		Movie movie = new Movie(411);
		ArrayList<Media> collection = MediaCollectionDB.getMediaCollection(collectionid);
		int count = 0;
		collection = MediaCollectionDB.getMediaCollection(collectionid);
		for(Media m: collection) {
			if(m.getId() == 411)
				count++;
			}
		assertEquals(1, count);
		
		assertTrue(MediaCollectionDB.removeMediaCollection(collectionid, 411));
		collection = MediaCollectionDB.getMediaCollection(collectionid);
		
		for(Media m: collection) {
			assertFalse(m.getId() == 411);			
		}
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
		Movie movie = new Movie(411);
		ArrayList<Media> collection = MediaCollectionDB.getMediaCollection(collectionid);
		for(Media m: collection) {
			assertFalse(m.getId() == 411);			
		}
		assertFalse(MediaCollectionDB.removeMediaCollection(collectionid, 411));
	}

}
