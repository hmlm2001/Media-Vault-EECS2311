package userinterface;

import java.awt.Image;

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
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ExploreUI extends JFrame {

	private JPanel contentPane;
	private Image mv_logo = new ImageIcon(getClass().getResource("/images/logos/mv-logo-white-with-text-no-bg.png")).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
	private Image user_icon = new ImageIcon(getClass().getResource("/images/icons/user-icon.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);

	/**
	 * Create the frame.
	 */
	public ExploreUI() {
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
		mediaVaultLogo.setIcon(new ImageIcon(mv_logo));
		mediaVaultLogo.setBounds(3, 6, 88, 59);
		navbar.add(mediaVaultLogo);
		
		JButton moviesButton = new JButton("MOVIES");
		moviesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		moviesButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		moviesButton.setForeground(Color.WHITE);
		moviesButton.setBackground(Color.DARK_GRAY);
		moviesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		moviesButton.setBorder(null);
		moviesButton.setBounds(111, 17, 76, 29);
		navbar.add(moviesButton);
		
		JButton booksButton = new JButton("BOOKS");
		booksButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		booksButton.setForeground(Color.WHITE);
		booksButton.setBackground(Color.DARK_GRAY);
		booksButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		booksButton.setBorder(null);
		booksButton.setBounds(211, 17, 76, 29);
		navbar.add(booksButton);
		
		JButton wishlistButton = new JButton("WISHLIST");
		wishlistButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		wishlistButton.setForeground(Color.WHITE);
		wishlistButton.setBackground(Color.DARK_GRAY);
		wishlistButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		wishlistButton.setBorder(null);
		wishlistButton.setBounds(406, 17, 88, 29);
		navbar.add(wishlistButton);
		
		JButton vaultButton = new JButton("VAULT");
		vaultButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		vaultButton.setForeground(Color.WHITE);
		vaultButton.setBackground(Color.DARK_GRAY);
		vaultButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		vaultButton.setBorder(null);
		vaultButton.setBounds(306, 17, 76, 29);
		navbar.add(vaultButton);
		
		JButton profileButton = new JButton("PROFILE");
		profileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		profileButton.setForeground(Color.WHITE);
		profileButton.setBackground(Color.DARK_GRAY);
		profileButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		profileButton.setBorder(null);
		profileButton.setBounds(517, 17, 88, 29);
		navbar.add(profileButton);
		
		JButton userIcon = new JButton("");
		userIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		userIcon.setIcon(new ImageIcon(user_icon));
		userIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		userIcon.setBackground(Color.DARK_GRAY);
		userIcon.setBorder(null);
		userIcon.setBounds(1120, 6, 53, 53);
		navbar.add(userIcon);
		
		JButton logOutButton = new JButton("LOG OUT");
		logOutButton.setBackground(Color.DARK_GRAY);
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUI frame = new LoginUI();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				ExploreUI.this.dispose();
			}
		});
		logOutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logOutButton.setForeground(Color.WHITE);
		logOutButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		logOutButton.setBorder(null);
		logOutButton.setBounds(1185, 17, 88, 29);
		navbar.add(logOutButton);
	}
}
