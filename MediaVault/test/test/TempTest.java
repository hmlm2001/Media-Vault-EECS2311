package test;

import  main.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TempTest {

	@Test
	void test() throws Exception {
		AllMedia sampledata = new AllMedia();
		
		System.out.print(sampledata.MediaMap.get("Saving Private Ryan").name + " "+ sampledata.MediaMap.get("Saving Private Ryan").releaseDate );
		
		Media inception = sampledata.searchMedia("Inception");
		
		System.out.print(inception.name + " " + inception.releaseDate );
	
	}

}