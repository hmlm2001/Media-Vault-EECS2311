package userinterface.swing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import persistence.MovieDuplicate;
import userinterface.MoviePageUI;

/**
 * This class is used to open a movie page when the movie is clicked
 */
public class MyMouseAdapter extends MouseAdapter {
	private int movieId;
	/**
	 * This constructor sets the movie id based on the given input
	 * @param id - id of the movie to be used
	 */
	public MyMouseAdapter(int id) {
		this.movieId = id;
	}
	
	/**
	 * Opens a new movie page when a specific movie is clicked
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		MoviePageUI frame = new MoviePageUI(new MovieDuplicate(movieId));
    	frame.setLocationRelativeTo(null);
    	frame.toFront();
    	frame.requestFocus();
		frame.setVisible(true);
	}
}
