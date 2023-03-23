package userinterface;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import backend.Movie;
import backend.Review;
import backend.User;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class AddReviewUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AddReviewUI(User user, Movie movie) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add Review - " + movie.getTitle());
		setResizable(false);
		setBounds(100, 100, 700, 300);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// User Icon
		JLabel userIcon = new JLabel();
		Image user_icon = new ImageIcon(getClass().getResource("/images/icons/user-icon" + Integer.toString(user.getUserIcon()) + ".png")).getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
		userIcon.setIcon(new ImageIcon(user_icon));
		userIcon.setBounds(6, 6, 60, 60);
		contentPane.add(userIcon);
		
		// Username
		JLabel username = new JLabel("<html>" + user.getUsername() + "</html>");
		username.setBounds(78, 24, 135, 20);
		contentPane.add(username);
		
		// Review
		JTextArea reviewTextArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(reviewTextArea);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(6, 71, 688, 152);
		reviewTextArea.setLineWrap(true);
		reviewTextArea.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		reviewTextArea.setFocusable(true);
		// Limiting the text area to accept a maximum of 600 characters
		reviewTextArea.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			    int max = 600;
			    if (reviewTextArea.getText().length() > max+1) {
			        e.consume();
			        String shortened = reviewTextArea.getText().substring(0, max);
			        reviewTextArea.setText(shortened);
			    } else if(reviewTextArea.getText().length() >= max) {
			        e.consume();
			    }
			}
			@Override
			public void keyPressed(KeyEvent e) {return;}
			@Override
			public void keyReleased(KeyEvent e) {return;	}
			
		});
		contentPane.add(scrollPane);
		
		// Add Review Button
		JButton addButton = new JButton("Add Review");
		addButton.setOpaque(true);
		addButton.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		addButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		addButton.setBackground(Color.WHITE);
		addButton.setBounds(274, 235, 163, 31);
		addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Review.add(movie, new Review(user, reviewTextArea.getText()));
				ViewReviewsUI frame = new ViewReviewsUI(user, movie);
		    	frame.setLocationRelativeTo(null);
		    	frame.toFront();
		    	frame.requestFocus();
				frame.setVisible(true);
				AddReviewUI.this.dispose();
			}
		});
		contentPane.add(addButton);
	}
}