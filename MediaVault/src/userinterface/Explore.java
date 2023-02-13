package userinterface;

import java.awt.EventQueue;
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

public class Explore extends JFrame {

	private JPanel contentPane;
	private Image mv_logo = new ImageIcon(getClass().getResource("/images/logos/mv-logo-white-with-text-no-bg.png")).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
	private Image user_icon = new ImageIcon(getClass().getResource("/images/icons/user-icon.png")).getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Explore frame = new Explore();
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
	public Explore() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1650, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel navbar = new JPanel();
		navbar.setBackground(Color.DARK_GRAY);
		navbar.setBounds(0, 0, 1650, 70);
		contentPane.add(navbar);
		navbar.setLayout(null);
		
		JLabel mediaVaultLogo = new JLabel("");
		mediaVaultLogo.setHorizontalAlignment(SwingConstants.CENTER);
		mediaVaultLogo.setIcon(new ImageIcon(mv_logo));
		mediaVaultLogo.setBounds(6, 6, 88, 59);
		navbar.add(mediaVaultLogo);
		
		JButton moviesButton = new JButton("MOVIES");
		moviesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		moviesButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		moviesButton.setForeground(Color.WHITE);
		moviesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		moviesButton.setBorder(null);
		moviesButton.setBounds(109, 20, 76, 29);
		navbar.add(moviesButton);
		
		JButton booksButton = new JButton("BOOKS");
		booksButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		booksButton.setForeground(Color.WHITE);
		booksButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		booksButton.setBorder(null);
		booksButton.setBounds(209, 20, 76, 29);
		navbar.add(booksButton);
		
		JButton wishlistButton = new JButton("WISHLIST");
		wishlistButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		wishlistButton.setForeground(Color.WHITE);
		wishlistButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		wishlistButton.setBorder(null);
		wishlistButton.setBounds(392, 20, 88, 29);
		navbar.add(wishlistButton);
		
		JButton vaultButton = new JButton("VAULT");
		vaultButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		vaultButton.setForeground(Color.WHITE);
		vaultButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		vaultButton.setBorder(null);
		vaultButton.setBounds(298, 20, 76, 29);
		navbar.add(vaultButton);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setIcon(new ImageIcon(user_icon));
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBorder(null);
		button.setBounds(1578, 2, 66, 64);
		navbar.add(button);
	}
}
