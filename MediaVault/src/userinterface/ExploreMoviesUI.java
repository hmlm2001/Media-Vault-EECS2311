package userinterface;

import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import persistence.MovieDB;
import persistence.Movie;

@SuppressWarnings("serial")
public class ExploreMoviesUI extends JFrame {

	private JPanel contentPane;
	private MovieDB allMovies;

	/**
	 * Create the frame.
	 */
	public ExploreMoviesUI() {
		setTitle("MediaVault");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel navbar = new JPanel();
		navbar.setBackground(Color.DARK_GRAY);
		navbar.setBounds(0, 0, 1650, 61);
		contentPane.add(navbar);
		navbar.setLayout(null);
		
		JLabel mediaVaultLogo = new JLabel("");
		mediaVaultLogo.setHorizontalAlignment(SwingConstants.CENTER);
		Image mv_logo = new ImageIcon(getClass().getResource("/images/logos/mv-logo-white-with-text-no-bg.png")).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
		mediaVaultLogo.setIcon(new ImageIcon(mv_logo));
		mediaVaultLogo.setBounds(3, 6, 88, 59);
		navbar.add(mediaVaultLogo);
		
		JButton moviesButton = new JButton("MOVIES");
		moviesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExploreMoviesUI frame = new ExploreMoviesUI();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				ExploreMoviesUI.this.dispose();
			}
		});
		moviesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		moviesButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		moviesButton.setForeground(Color.WHITE);
		moviesButton.setBackground(Color.DARK_GRAY);
		moviesButton.setBorder(null);
		moviesButton.setBounds(103, 17, 76, 29);
		navbar.add(moviesButton);
		
		JButton vaultButton = new JButton("VAULT");
		vaultButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		vaultButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		vaultButton.setForeground(Color.WHITE);
		vaultButton.setBackground(Color.DARK_GRAY);
		vaultButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		vaultButton.setBorder(null);
		vaultButton.setBounds(203, 17, 76, 29);
		navbar.add(vaultButton);
		
		JButton userIcon = new JButton("");
		userIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Image user_icon = new ImageIcon(getClass().getResource("/images/icons/user-icon.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		userIcon.setIcon(new ImageIcon(user_icon));
		userIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		userIcon.setBackground(Color.DARK_GRAY);
		userIcon.setBorder(null);
		userIcon.setBounds(1116, 6, 53, 53);
		navbar.add(userIcon);
		
		JButton logOutButton = new JButton("LOG OUT");
		logOutButton.setBackground(Color.DARK_GRAY);
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUI frame = new LoginUI();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				ExploreMoviesUI.this.dispose();
			}
		});
		logOutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logOutButton.setForeground(Color.WHITE);
		logOutButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		logOutButton.setBorder(null);
		logOutButton.setBounds(1185, 17, 88, 29);
		navbar.add(logOutButton);
		
		JPanel mainContent = new JPanel();
		mainContent.setBackground(Color.WHITE);
		JScrollPane mainScrollPane = new JScrollPane(mainContent);
		mainContent.setLayout(null);
		
		JLabel actionLabel = new JLabel("ACTION");
		actionLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		actionLabel.setBackground(Color.WHITE);
		actionLabel.setBounds(6, 41, 77, 21);
		mainContent.add(actionLabel);
		
		mainScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		mainScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mainScrollPane.setBounds(0, 61, 1300, 611);
		contentPane.add(mainScrollPane);
		
		allMovies = new MovieDB();
		String path = allMovies.get(6).getPosterPath();
		try {
			URL url = new URL(path);
			BufferedImage image = ImageIO.read(url);
			Image poster = new ImageIcon(image).getImage().getScaledInstance(180, 250, Image.SCALE_SMOOTH);
	        JLabel label = new JLabel(new ImageIcon(poster));
	        label.setBounds(6, 71, 162, 247);
	        mainContent.add(label);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
