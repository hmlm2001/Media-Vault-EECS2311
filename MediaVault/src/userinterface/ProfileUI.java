package userinterface;

import userinterface.swing.*;

import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.chart.ChartPanel;

import backend.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

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
					ProfileUI frame = new ProfileUI(new User("user1"));
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
		MediaCollection collection = new MediaCollection(user.getId());
		setTitle("MediaVault");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1305, 700);		
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
		moviesButton.addActionListener(new ActionListener() {
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
		vaultButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VaultUI frame = new VaultUI(user);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				ProfileUI.this.dispose();
			}
		});
		vaultButton.setBorder(null);
		vaultButton.setBounds(203, 17, 76, 29);
		navbar.add(vaultButton);
		
		SearchbarLogoSetup setup = new SearchbarLogoSetup(navbar);
		setup.setUser(user);
		
		// User Icon
		JButton userIcon = new JButton();
		Image user_icon = new ImageIcon(getClass().getResource("/images/icons/user-icon" + Integer.toString(user.getUserIcon()) + ".png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
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
        
		//TODO add everything below into scrollpane
		JPanel statsPane = new JPanel();
		statsPane.setBackground(Color.WHITE);
		statsPane.setLayout(null);
		statsPane.setPreferredSize(new Dimension(1305, 639));
		
		JScrollPane scroll = new JScrollPane(statsPane);
		contentPane.add(scroll, BorderLayout.CENTER);
		scroll.setBounds(0, 61, 1650, 639);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setViewportView(statsPane);
		scroll.getVerticalScrollBar().setPreferredSize(new Dimension(45, 0));
		
		
        // Personalization Section			
        JLabel personalizationLabel = new JLabel("PERSONALIZATION");
		personalizationLabel.setFont(new Font("Lucida Grande", Font.BOLD, 19));
		personalizationLabel.setBounds(10, 12, 194, 23);
		statsPane.add(personalizationLabel);
		
		JLabel descriptionLabel = new JLabel("Change profile picture");
		descriptionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		descriptionLabel.setBounds(11, 42, 168, 23);
		statsPane.add(descriptionLabel);
		
		JSeparator personalizationSeparator = new JSeparator();
		personalizationSeparator.setBounds(10, 33, 950, 12);
		statsPane.add(personalizationSeparator);
		
		JPanel userIconPanel = new JPanel();
		userIconPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
		userIconPanel.setBounds(11, 69, 671, 103);
		statsPane.add(userIconPanel);
		
		JButton setButton = new JButton("Set as Profile Picture");
		setButton.setOpaque(true);
		setButton.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		setButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		setButton.setBackground(Color.WHITE);
		setButton.setBounds(719, 106, 204, 30);
		// Button is not visible until an icon is selected
		setButton.setVisible(false);
		setButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 7; i++) {
					// Set the user icon to the currently selected icon
					if (((JComponent) userIconPanel.getComponent(i)).getBorder() != null) {
						user.setUserIcon(i+1);
					}
				}
				// Reload the window
				ProfileUI frame = new ProfileUI(user);
		    	frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				ProfileUI.this.dispose();
			}
		});
		statsPane.add(setButton);
		
		displayUserIcons(userIconPanel, setButton, user);
		
		// User Statistics Section
		JLabel userStatsLabel = new JLabel("USER STATISTICS");
		userStatsLabel.setFont(new Font("Lucida Grande", Font.BOLD, 19));
		userStatsLabel.setBounds(10, 184, 180, 23);
		statsPane.add(userStatsLabel);
		
		JSeparator personalizationSeparator_1 = new JSeparator();
		personalizationSeparator_1.setBounds(10, 205, 950, 12);
		statsPane.add(personalizationSeparator_1);
		
		//TODO: Make stats panel with flow layout
		
		// Total Watchtime
		JLabel totalWatchtimeLabel = new JLabel("Total Watchtime: " + collection.getTotalWatchtime());
		totalWatchtimeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		totalWatchtimeLabel.setBounds(10, 214, 214, 23);
		statsPane.add(totalWatchtimeLabel);
		
		// Vault Status Distribution
		CategoryDataset barDataset = collection.createStatusDataset();
		
		this.displayStatusDistribution(statsPane, barDataset);
		
		// Vault Genre Distribution
		PieDataset pieDataset = collection.createGenreDataset();
		
		this.displayGenreDistribution(statsPane, pieDataset);
	}
	
	/**
	 * Displays the user icons in the given userIconPanel
	 * @param userIconPanel to display the icons in
	 * @param setButton to set the selected icon for the user
	 * @param user who's icon should be changed
	 */
	private void displayUserIcons(JPanel userIconPanel, JButton setButton, User user) {
		for (int i = 1; i <= 7; i++) {
			JButton pfp = new JButton();
			Image pfp_img = new ImageIcon(getClass().getResource("/images/icons/user-icon" + i + ".png")).getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH);
			pfp.setIcon(new ImageIcon(pfp_img));
			pfp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			pfp.setBackground(Color.BLACK);
			if (i == user.getUserIcon()) {
				pfp.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			} else {
				pfp.setBorder(null);
			}
			// Create a border for the currently selected icon, remove the border on any other icon, and make the button visible 
			pfp.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (Component button : userIconPanel.getComponents()) {
						((JComponent) button).setBorder(null);
					}
					setButton.setVisible(true);
					pfp.setBorder(new LineBorder(new Color(0, 0, 0), 3));
				}
			});
			userIconPanel.add(pfp);
		}
	}
	
	/**
	 * Displays the user's movie genre distribution as a pie chart
	 * @param statsPanel
	 * @param pieDataset
	 */
	private void displayGenreDistribution(JPanel statsPanel, PieDataset pieDataset) {
		JFreeChart pieChart = ChartFactory.createPieChart("Genre Distribution", pieDataset, true, true, false);
		
		ChartPanel piePanel = new ChartPanel(pieChart);
		statsPanel.add(piePanel);
		piePanel.setBounds(23 + ChartPanel.DEFAULT_WIDTH * 371 / ChartPanel.DEFAULT_HEIGHT, 250, ChartPanel.DEFAULT_WIDTH * 376 / ChartPanel.DEFAULT_HEIGHT, 376);
	}
	
	/**
	 * Displays the user's movie status distribution as a bar chart
	 * @param statsPanel
	 * @param barDataset
	 */
	private void displayStatusDistribution(JPanel statsPanel, CategoryDataset barDataset) {
		JFreeChart barChart = ChartFactory.createBarChart("Status Distribution", "Status", "Number of Movies", barDataset, PlotOrientation.VERTICAL, true, true, false);
		barChart.setBackgroundPaint(Color.white);
		CategoryPlot plot = barChart.getCategoryPlot();
        plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        
        ChartPanel barPanel = new ChartPanel(barChart);
        statsPanel.add(barPanel);
        barPanel.setBounds(10, 250, ChartPanel.DEFAULT_WIDTH * 371 / ChartPanel.DEFAULT_HEIGHT, 376);
        barPanel.setVisible(true);
	}
}