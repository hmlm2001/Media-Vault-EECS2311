package userinterface.swing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;

/**
 * This class is used to create popup menus
 */
public class PopupListener extends MouseAdapter {
	JPopupMenu popup;
	
	/**
	 * This constructor sets the popup menu based on the given input
	 * @param popup - popup menu to be used
	 */
	public PopupListener(JPopupMenu popup) {
		this.popup = popup;
	}
	
	/**
	 * Called when the mouse is clicked/pressed
	 */
	public void mousePressed(MouseEvent e) {
        ShowPopup(e);
    }
	
	/**
	 * Used to show the popup menu
	 * @param e - the MouseEvent to be monitored
	 */
	private void ShowPopup(MouseEvent e) {    		
			popup.show(e.getComponent(), e.getX(), e.getY());
    }
}
