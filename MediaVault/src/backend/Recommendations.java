package backend;


import java.util.ArrayList;

import persistence.ReccomendationsDB;



public class Recommendations {
	private Recommendations() {
		
	}
	public static ArrayList<Media> get(int mediaCollectonId, int n){
		return ReccomendationsDB.get(mediaCollectonId, n);
	}
	public static void main(String[] args) {
		ArrayList<Media> list = Recommendations.get(1,10);
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i).getTitle());
		}
	}
}
