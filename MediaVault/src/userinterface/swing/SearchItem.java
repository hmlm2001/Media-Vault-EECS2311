package userinterface.swing;

import java.awt.Color;
import javax.swing.JPanel;
import persistence.*;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 */
@SuppressWarnings("serial")
public class SearchItem extends JPanel {

	/**
	 * This constructor initializes the search item and adds the given movie to the search list
	 * @param movie - movie to be used
	 */
    public SearchItem(Movie movie) {
        initComponents();
        setMovie(movie);
    }

    /**
     * Sets the text on each search item to the title of a movie
     * @param movie - movie to be used
     */
    private void setMovie(Movie movie) {
        addEventMouse(this);
        addEventMouse(lbText);
        lbText.setText(movie.getTitle());
    }

    /**
     * Adds a MouseListener to a component upon mouse entry and exit
     * @param com - component to add MouseListener to
     */
    private void addEventMouse(Component com) {
        com.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(new Color(215, 216, 216));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(Color.WHITE);
            }

        });
    }

    private ActionListener eventClick;

    /**
     * Adds an ActionListener to an object 
     * @param eventClick - ActionListener to be added
     */
    public void addEvent(ActionListener eventClick) {
        this.eventClick = eventClick;
    }

    /**
     * This method is called from within the constructor to initialize the search item.
     */
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbText = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_small.png")));

        lbText.setFont(new java.awt.Font("sansserif", 0, 14));
        lbText.setForeground(new java.awt.Color(38, 38, 38));
        lbText.setText("Text ...");
        lbText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTextMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(lbIcon, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lbText, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(lbIcon, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        		.addComponent(lbText, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );
        this.setLayout(layout);
    }

    /**
     * Used to change the label text when the mouse is clicked
     * @param evt - The MouseEvent that occurs (mouse is clicked)
     */
    private void lbTextMouseClicked(java.awt.event.MouseEvent evt) {
        eventClick.actionPerformed(null);
    }

    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbText;
}
