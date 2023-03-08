package userinterface.swing;

import java.awt.event.ActionListener;

/**
 * This class is used to retrieve user ids when opening UI classes
 */
public abstract class MyActionListener implements ActionListener {
	public int userId;
	
	/**
	 * This method creates an ActionListener that stores the required user id.
	 * @param userId - the user id to be used
	 */
	public MyActionListener(int userId) {
		this.userId = userId;
	}
}
