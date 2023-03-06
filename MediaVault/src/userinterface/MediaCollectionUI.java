package userinterface;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

@SuppressWarnings("serial")
public class MediaCollectionUI  extends JFrame{
	private JPanel contentPane;
	private Image mv_logo = new ImageIcon(getClass().getResource("/images/logos/mv-logo-white-with-text-no-bg.png")).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
	private Image user_icon = new ImageIcon(getClass().getResource("/images/icons/user-icon.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);

	
	public MediaCollectionUI () {
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
		navbar.setLayout(null);
		navbar.setBackground(Color.DARK_GRAY);
		navbar.setBounds(0, 0, 1650, 61);
		contentPane.add(navbar);
		
		JLabel mediaVaultLogo = new JLabel("");
		mediaVaultLogo.setHorizontalAlignment(SwingConstants.CENTER);
		mediaVaultLogo.setIcon(new ImageIcon(mv_logo));
		mediaVaultLogo.setBounds(3, 6, 88, 59);
		navbar.add(mediaVaultLogo);
		
		JButton moviesButton = new JButton("MOVIES");
		moviesButton.setForeground(Color.WHITE);
		moviesButton.setFont(new Font("Dialog", Font.BOLD, 18));
		moviesButton.setBorder(null);
		moviesButton.setBackground(Color.DARK_GRAY);
		moviesButton.setBounds(111, 17, 76, 29);
		navbar.add(moviesButton);
		
		JButton booksButton = new JButton("BOOKS");
		booksButton.setForeground(Color.WHITE);
		booksButton.setFont(new Font("Dialog", Font.BOLD, 18));
		booksButton.setBorder(null);
		booksButton.setBackground(Color.DARK_GRAY);
		booksButton.setBounds(211, 17, 76, 29);
		navbar.add(booksButton);
		
		JButton wishlistButton = new JButton("WISHLIST");
		wishlistButton.setForeground(Color.WHITE);
		wishlistButton.setFont(new Font("Dialog", Font.BOLD, 18));
		wishlistButton.setBorder(null);
		wishlistButton.setBackground(Color.DARK_GRAY);
		wishlistButton.setBounds(406, 17, 88, 29);
		navbar.add(wishlistButton);
		
		JButton vaultButton = new JButton("VAULT");
		vaultButton.setForeground(Color.WHITE);
		vaultButton.setFont(new Font("Dialog", Font.BOLD, 18));
		vaultButton.setBorder(null);
		vaultButton.setBackground(Color.DARK_GRAY);
		vaultButton.setBounds(306, 17, 76, 29);
		navbar.add(vaultButton);
		
		JButton profileButton = new JButton("PROFILE");
		profileButton.setForeground(Color.WHITE);
		profileButton.setFont(new Font("Dialog", Font.BOLD, 18));
		profileButton.setBorder(null);
		profileButton.setBackground(Color.DARK_GRAY);
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
		logOutButton.setForeground(Color.WHITE);
		logOutButton.setFont(new Font("Dialog", Font.BOLD, 18));
		logOutButton.setBorder(null);
		logOutButton.setBackground(Color.DARK_GRAY);
		logOutButton.setBounds(1185, 17, 88, 29);
		navbar.add(logOutButton);
		
	}
}
