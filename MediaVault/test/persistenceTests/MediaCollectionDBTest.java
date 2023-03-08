package persistenceTests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.Media;
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
	
	@Test
	void getMediaCollectionTest() throws SQLException {
		
				
	}
	
	@Test
	void addMediaCollectionTest() throws SQLException {
		
				
	}
	
	@Test
	void removeMediaCollectionTest() throws SQLException {
		
				
	}
}
