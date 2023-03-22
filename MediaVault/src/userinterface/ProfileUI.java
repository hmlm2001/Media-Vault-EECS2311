package userinterface;

import persistence.*;
import userinterface.swing.*;

import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import backend.User;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class ProfileUI extends JFrame {

	private JPanel contentPane;
    private JPopupMenu profilePopup;
    private JMenuItem menuItem;
    
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileUI frame = new ProfileUI(new User(10));
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
	public ProfileUI(User user) {
		setTitle("MediaVault");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1305, 660);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		// Navbar
		JPanel navbar = new JPanel();
		navbar.setBackground(Color.DARK_GRAY);
		navbar.setBounds(0, 0, 1650, 61);
		contentPane.add(navbar);
		navbar.setLayout(null);
		
		JButton moviesButton = new JButton("MOVIES");
		moviesButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		moviesButton.setForeground(Color.GRAY);
		moviesButton.setBackground(Color.DARK_GRAY);
		moviesButton.setBorder(null);
		moviesButton.setBounds(103, 17, 76, 29);
		moviesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		moviesButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				moviesButton.setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent e) {
				moviesButton.setForeground(Color.GRAY);
			}
		});
		moviesButton.addActionListener(new MyActionListener(user.getId()) {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ExploreMoviesUI frame = new ExploreMoviesUI(user);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				ProfileUI.this.dispose();
			}
		});
		navbar.add(moviesButton);
		
		JButton vaultButton = new JButton("VAULT");
		vaultButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				vaultButton.setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent e) {
				vaultButton.setForeground(Color.GRAY);
			}
		});
		vaultButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		vaultButton.setForeground(Color.GRAY);
		vaultButton.setBackground(Color.DARK_GRAY);
		vaultButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		vaultButton.addActionListener(new MyActionListener(user.getId()) {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VaultUI frame = new VaultUI(user.getId());
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				ProfileUI.this.dispose();
			}
		});
		vaultButton.setBorder(null);
		vaultButton.setBounds(203, 17, 76, 29);
		navbar.add(vaultButton);
		
		SearchbarLogoSetup setup = new SearchbarLogoSetup(navbar);
		setup.setUserId(user.getId());
		
		// User Icon
		JButton userIcon = new JButton();
		userIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Image user_icon = new ImageIcon(getClass().getResource("/images/icons/user-icon2.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		userIcon.setIcon(new ImageIcon(user_icon));
		userIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		userIcon.setBackground(Color.BLACK);
		userIcon.setBorder(null);
		userIcon.setBounds(1233, 4, 53, 53);
		
		// Popup Menu for user icon
		profilePopup = new JPopupMenu();
		MouseListener popupListener = new PopupListener(profilePopup);
		userIcon.addMouseListener(popupListener);
		
		JLabel username = new JLabel(user.getUsername());
	    username.setBackground(new Color(31, 31, 31));
		username.setForeground(Color.WHITE);
		username.setFont(username.getFont().deriveFont(Font.ITALIC));
        username.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        username.setCursor(Cursor.getDefaultCursor());
	    profilePopup.add(username);
	    
	    menuItem = new JMenuItem("Profile");
	    menuItem.setBackground(new Color(31, 31, 31));
		menuItem.setForeground(Color.WHITE);
	    menuItem.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		ProfileUI frame = new ProfileUI(user);
	    		frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				ProfileUI.this.dispose();
	    	}
	    });
	    profilePopup.add(menuItem);
	    
	    menuItem = new JMenuItem("Log Out");
	    menuItem.setBackground(new Color(31, 31, 31));
		menuItem.setForeground(Color.WHITE);
	    menuItem.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		LoginUI frame = new LoginUI();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				ProfileUI.this.dispose();
	    	}
	    });
	    profilePopup.add(menuItem);
	    profilePopup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		profilePopup.setBackground(new Color(31, 31, 31));
		navbar.add(userIcon);		
        
        // Main Section			
        JScrollPane mainScrollPane = new JScrollPane();
        mainScrollPane.setBounds(0, 61, 1305, 572);
        contentPane.add(mainScrollPane);
        mainScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        mainScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(20, 0));
        mainScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        JPanel mainContent = new JPanel();
        mainContent.setPreferredSize(new Dimension(1300, 1415));
        mainScrollPane.setViewportView(mainContent);
        mainContent.setBackground(Color.WHITE);
        mainContent.setLayout(null);
        
        JLabel personalizationLabel = new JLabel("PERSONALIZATION");
		personalizationLabel.setFont(new Font("Lucida Grande", Font.BOLD, 19));
		personalizationLabel.setBounds(6, 9, 203, 23);
		mainContent.add(personalizationLabel);
		
	}
}