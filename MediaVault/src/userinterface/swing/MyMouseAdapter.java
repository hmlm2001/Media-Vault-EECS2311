package userinterface.swing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import backend.*;
import userinterface.MoviePageUI;

/**
 * This class is used to open a movie page when the movie is clicked
 */
public class MyMouseAdapter extends MouseAdapter {
	private User user;
	private int movieId;
	/**
	 * This constructor sets the user and movie ids based on the given input
	 * @param userId - id of the user
	 * @param movieId - id of the movie to be used
	 */
	public MyMouseAdapter(User user, int movieId) {
		this.user = user;
		this.movieId = movieId;
	}
	
	/**
	 * Opens a new movie page when a specific movie is clicked
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		MoviePageUI frame = new MoviePageUI(user, new Movie(movieId));
    	frame.setLocationRelativeTo(null);
    	frame.toFront();
    	frame.requestFocus();
		frame.setVisible(true);
	}
}
