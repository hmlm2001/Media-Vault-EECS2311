package userinterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class ViewReviewsUI extends JDialog {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ViewReviewsUI(User user, Movie movie) {
		setModal(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Reviews - " + movie.getTitle());
		setResizable(false);
		setBounds(100, 100, 700, 500);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ArrayList<Review> reviews = Review.get(movie);
		
		JLabel reviewsLabel = new JLabel("Reviews");
		reviewsLabel.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		reviewsLabel.setBounds(6, 10, 119, 30);
		contentPane.add(reviewsLabel);
		
		JPanel mainContent = new JPanel();
		mainContent.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainContent.setBackground(Color.WHITE);
		mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
		mainContent.setBounds(6, 50, 688, 416);
		contentPane.add(mainContent);
		
		JButton addReviewButton = new JButton("+ Add a Review");
		addReviewButton.setOpaque(true);
		addReviewButton.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		addReviewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addReviewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		addReviewButton.setBackground(Color.WHITE);
		addReviewButton.setBounds(525, 11, 169, 31);
		addReviewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewReviewsUI.this.setVisible(false);
				ViewReviewsUI.this.dispose();
				AddReviewUI frame = new AddReviewUI(user, movie);
				frame.setLocationRelativeTo(null);
				frame.setAlwaysOnTop(true);
		        frame.setVisible(true);		
			}
		});
		contentPane.add(addReviewButton);
		 
		if (reviews.isEmpty()) {
			JLabel noReviewsLabel = new JLabel("No reviews available for this movie.");
			noReviewsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			mainContent.add(noReviewsLabel);
		} else {
			for (Review review : reviews) {
				addReviewToPanel(mainContent, review);
			}
		}
	}
	
	private void addReviewToPanel(JPanel mainContent, Review reviewObj) {
		User user = reviewObj.getUser();
		String review = reviewObj.getReview();

		// Panel for the review
		JPanel reviewPanel = new JPanel();
		reviewPanel.setPreferredSize(new Dimension(668, 50));
		mainContent.add(reviewPanel);
		reviewPanel.setLayout(null);
		
		// User Icon
		JLabel userIcon = new JLabel();
		Image user_icon = new ImageIcon(getClass().getResource("/images/icons/user-icon" + Integer.toString(user.getUserIcon()) + ".png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		userIcon.setIcon(new ImageIcon(user_icon));
		userIcon.setBounds(6, 8, 45, 45);
		reviewPanel.add(userIcon);
		
		// Username
		JLabel username = new JLabel("<html>" + user.getUsername() + "</html>");
		username.setVerticalAlignment(SwingConstants.TOP);
		username.setBounds(6, 60, 80, 45);
		reviewPanel.add(username);
		
		// Vertical Separator
		JSeparator verticalSeparator = new JSeparator();
		verticalSeparator.setOrientation(SwingConstants.VERTICAL);
		verticalSeparator.setBounds(91, -1, 12, 135);
		reviewPanel.add(verticalSeparator);
		
		// Review
		JLabel reviewLabel = new JLabel("<html>" + review + "</html>");
		reviewLabel.setVerticalAlignment(SwingConstants.TOP);
		reviewLabel.setBounds(104, 8, 570, 125);
		reviewPanel.add(reviewLabel);
		
		// Top Separator
		JSeparator topSeparator = new JSeparator();
		topSeparator.setBounds(0, -5, 688, 10);
		reviewPanel.add(topSeparator);
		
		// Bottom Separator
		JSeparator bottomSeparator = new JSeparator();
		bottomSeparator.setBounds(0, 128, 688, 10);
		reviewPanel.add(bottomSeparator);
	}
}