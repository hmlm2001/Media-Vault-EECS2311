package userinterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import backend.Movie;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class ReviewsUI extends JFrame {

	private JPanel contentPane;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ReviewsUI frame = new ReviewsUI(10, new Movie(411));
//			    	frame.setLocationRelativeTo(null);
//			    	frame.toFront();
//			    	frame.requestFocus();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	/**
	 * Create the frame.
	 */
	public ReviewsUI(int userId, Movie movie) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Reviews - " + movie.getTitle());
		setResizable(false);
		setBounds(100, 100, 700, 500);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel reviewsLabel = new JLabel("Reviews");
		reviewsLabel.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		reviewsLabel.setBounds(6, 10, 119, 30);
		contentPane.add(reviewsLabel);
		
		JButton addReviewButton = new JButton("+ Add a Review");
		addReviewButton.setOpaque(true);
		addReviewButton.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		addReviewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addReviewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		addReviewButton.setBackground(Color.WHITE);
		addReviewButton.setBounds(525, 11, 169, 31);
		contentPane.add(addReviewButton);
		
		JPanel mainContent = new JPanel();
		mainContent.setBackground(Color.WHITE);
		JScrollPane scrollPane = new JScrollPane(mainContent);
		mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
		scrollPane.setBounds(6, 50, 688, 416);
		contentPane.add(scrollPane);
		
		JLabel noReviewsLabel = new JLabel("No reviews available for this movie.");
		noReviewsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		mainContent.add(noReviewsLabel);
	}
}