package userinterface;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.*;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class MoviePageUI extends JFrame {

	private JPanel contentPane;
		
	/**
	 * Create the frame.
	 */
	public MoviePageUI(int userId, Movie movie) {
		MediaCollection movieList = new MediaCollection(userId);
		
		setTitle(movie.getTitle());
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 820, 580);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String path = movie.getPosterPath();
		try {
			URL url = new URL(path);
			BufferedImage image = ImageIO.read(url);
			Image poster = new ImageIcon(image).getImage().getScaledInstance(400, 520, Image.SCALE_SMOOTH);
			JLabel moviePoster = new JLabel(new ImageIcon(poster));
			moviePoster.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			moviePoster.setBounds(16, 10, 391, 521);
			contentPane.add(moviePoster);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel title = new JLabel("<html>" + movie.getTitle() + "</html>");
		title.setVerticalAlignment(SwingConstants.BOTTOM);
		title.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		title.setBounds(419, 10, 383, 53);
		contentPane.add(title);
		
		JLabel releaseAndGenre = new JLabel(movie.getReleaseDate() + " | " + movie.getGenre());
		releaseAndGenre.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		releaseAndGenre.setBounds(419, 67, 383, 31);
		releaseAndGenre.setVerticalAlignment(JLabel.TOP);
		contentPane.add(releaseAndGenre);
		
		JLabel runtime = new JLabel(movie.getRuntimeAsString());
		runtime.setVerticalAlignment(SwingConstants.TOP);
		runtime.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		runtime.setBounds(419, 98, 383, 31);
		contentPane.add(runtime);
		
		JLabel overviewLabel = new JLabel("Overview");
		overviewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		overviewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		overviewLabel.setBounds(419, 121, 383, 31);
		contentPane.add(overviewLabel);
		
		JLabel overview = new JLabel("<html>" + movie.getOverview() + "</html>");
		overview.setVerticalAlignment(SwingConstants.TOP);
		overview.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		overview.setBounds(419, 160, 389, 314);
		contentPane.add(overview);
		
		JLabel successPrompt = new JLabel();
		contentPane.add(successPrompt);
		
		JButton addButton = new JButton("+ Add to Vault");
		addButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		addButton.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (movieList.addMedia(movie)) {
					successPrompt.setForeground(new Color(52, 200, 15));
					successPrompt.setBounds(540, 516, 200, 20);
					successPrompt.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
					successPrompt.setText("Successfully Added!");
					Timer t = new Timer(800, new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
							MoviePageUI.this.dispose();
					    }
					});
					t.setRepeats(false);
					t.start();
				} else {
					successPrompt.setForeground(Color.RED);
					successPrompt.setBounds(550, 516, 200, 20);
					successPrompt.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
					successPrompt.setText("Already in Vault!");
					Timer t = new Timer(800, new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
							MoviePageUI.this.dispose();
					    }
					});
					t.setRepeats(false);
					t.start();
				}
			}
		});
		addButton.setOpaque(true);
		addButton.setBackground(Color.WHITE);
		addButton.setBounds(621, 480, 181, 31);
		contentPane.add(addButton);
		
		JButton reviewsButton = new JButton("View Reviews");
		reviewsButton.setOpaque(true);
		reviewsButton.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		reviewsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ReviewsUI frame = new ReviewsUI(userId, movie);
		    	frame.setLocationRelativeTo(null);
		    	frame.toFront();
		    	frame.requestFocus();
				frame.setVisible(true);
			}
		});
		reviewsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reviewsButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		reviewsButton.setBackground(Color.WHITE);
		reviewsButton.setBounds(421, 480, 181, 31);
		contentPane.add(reviewsButton);
		
	}
}
