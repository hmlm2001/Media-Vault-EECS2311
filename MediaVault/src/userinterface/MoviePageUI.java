package userinterface;

import java.awt.Color;
import java.awt.EventQueue;
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

import persistence.Movie;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class MoviePageUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoviePageUI frame = new MoviePageUI(new Movie(67308));
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public MoviePageUI(Movie movie) {
		setTitle(movie.getTitle());
		setResizable(false);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String path = movie.getPosterPath();
		try {
			URL url = new URL(path);
			BufferedImage image = ImageIO.read(url);
			Image poster = new ImageIcon(image).getImage().getScaledInstance(375, 500, Image.SCALE_SMOOTH);
			JLabel moviePoster = new JLabel(new ImageIcon(poster));
			moviePoster.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			moviePoster.setBounds(16, 10, 371, 498);
			contentPane.add(moviePoster);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel title = new JLabel("<html>" + movie.getTitle() + "</html>");
		title.setVerticalAlignment(SwingConstants.BOTTOM);
		title.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		title.setBounds(399, 10, 383, 53);
		contentPane.add(title);
		
		JLabel releaseAndGenre = new JLabel(movie.getReleaseDate() + " | " + movie.getGenre());
		releaseAndGenre.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		releaseAndGenre.setBounds(399, 70, 383, 31);
		releaseAndGenre.setVerticalAlignment(JLabel.TOP);
		contentPane.add(releaseAndGenre);
		
		JLabel runtime = new JLabel(movie.getRuntimeAsString());
		runtime.setVerticalAlignment(SwingConstants.TOP);
		runtime.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		runtime.setBounds(399, 102, 383, 31);
		contentPane.add(runtime);
		
		JLabel overviewLabel = new JLabel("Overview");
		overviewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		overviewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		overviewLabel.setBounds(399, 132, 383, 31);
		contentPane.add(overviewLabel);
		
		JLabel overview = new JLabel("<html>" + movie.getOverview() + "</html>");
		overview.setVerticalAlignment(SwingConstants.TOP);
		overview.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		overview.setBounds(399, 167, 383, 292);
		contentPane.add(overview);
		
		JButton addToVaultButton = new JButton("+ Add to Vault");
		addToVaultButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		addToVaultButton.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		addToVaultButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addToVaultButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MoviePageUI.this.dispose();
			}
		});
		addToVaultButton.setOpaque(true);
		addToVaultButton.setBackground(Color.WHITE);
		addToVaultButton.setBounds(495, 463, 181, 31);
		contentPane.add(addToVaultButton);
		
	}
}
