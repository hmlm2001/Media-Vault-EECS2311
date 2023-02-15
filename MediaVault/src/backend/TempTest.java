package backend;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TempTest {

	@Test
	void test() throws Exception {
		AllMedia sampledata = new AllMedia();
		
		System.out.print(sampledata.searchMedia("Saving Private Ryan").name + " "+ sampledata.searchMedia("Saving Private Ryan").releaseDate );
		
		Media inception = sampledata.searchMedia("Inception");
		
		System.out.print(inception.name + " " + inception.releaseDate );
	
	}

}