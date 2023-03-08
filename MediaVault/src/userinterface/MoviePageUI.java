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

import persistence.Movie;
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
		releaseAndGenre.setBounds(399, 67, 383, 31);
		releaseAndGenre.setVerticalAlignment(JLabel.TOP);
		contentPane.add(releaseAndGenre);
		
		JLabel runtime = new JLabel(movie.getRuntimeAsString());
		runtime.setVerticalAlignment(SwingConstants.TOP);
		runtime.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		runtime.setBounds(399, 98, 383, 31);
		contentPane.add(runtime);
		
		JLabel overviewLabel = new JLabel("Overview");
		overviewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		overviewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		overviewLabel.setBounds(399, 123, 383, 31);
		contentPane.add(overviewLabel);
		
		JLabel overview = new JLabel("<html>" + movie.getOverview() + "</html>");
		overview.setVerticalAlignment(SwingConstants.TOP);
		overview.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		overview.setBounds(399, 158, 383, 308);
		contentPane.add(overview);
		
		JLabel successPrompt = new JLabel();
		contentPane.add(successPrompt);
		
		JButton addToVaultButton = new JButton("+ Add to Vault");
		addToVaultButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		addToVaultButton.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		addToVaultButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addToVaultButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				successPrompt.setForeground(new Color(52, 200, 15));
				successPrompt.setBounds(518, 498, 200, 20);
				successPrompt.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				successPrompt.setText("Successfully Added!");
				Timer t = new Timer(1300, new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
						MoviePageUI.this.dispose();
				    }
				});
				t.setRepeats(false);
				t.start();
			}
		});
		addToVaultButton.setOpaque(true);
		addToVaultButton.setBackground(Color.WHITE);
		addToVaultButton.setBounds(495, 470, 181, 28);
		contentPane.add(addToVaultButton);
		
	}
}
