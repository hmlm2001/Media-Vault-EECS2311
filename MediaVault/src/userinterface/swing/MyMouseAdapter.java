package userinterface.swing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import persistence.Movie;
import userinterface.MoviePageUI;

public class MyMouseAdapter extends MouseAdapter {
	private int movieId;
	public MyMouseAdapter(int id) {
		this.movieId = id;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		MoviePageUI frame = new MoviePageUI(new Movie(movieId));
    	frame.setLocationRelativeTo(null);
    	frame.toFront();
    	frame.requestFocus();
		frame.setVisible(true);
	}
}
