package userinterface.swing;

import backend.*;

public interface EventClick {
	/**
	 * Used to define what happens when an item is clicked
	 * @param movieDuplicate - item to be clicked
	 */
    public void itemClick(Movie movie);

}
