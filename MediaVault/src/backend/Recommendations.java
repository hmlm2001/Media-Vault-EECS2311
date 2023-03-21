package backend;


import java.util.ArrayList;

import persistence.ReccomendationsDB;



public class Recommendations {
	/**
	 * makes it so no constructor can be made
	 */
	private Recommendations() {
		
	}
	/**
	 * gets a set of n media to offer as recommendation that do not already exist within the user's vault
	 * @param mediaCollectonId is the collection id
	 * @param n the number of recommendations
	 * @return the arraylist of media containing the reccomendations
	 */
	public static ArrayList<Media> get(int mediaCollectonId, int n){
		return ReccomendationsDB.get(mediaCollectonId, n);
	}
}
