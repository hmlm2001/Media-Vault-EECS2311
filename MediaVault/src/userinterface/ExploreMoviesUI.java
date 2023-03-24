package userinterface;

import persistence.*;
import backend.*;
import userinterface.swing.*;

import java.awt.Image;
import java.awt.Point;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class ExploreMoviesUI extends JFrame {

	private JPanel contentPane;
	private AllMoviesDB allMovies;
	private JPopupMenu profilePopup;
	private JMenuItem menuItem;
    
	/**
	 * Create the frame.
	 */
	public ExploreMoviesUI(User user) {
		int userId = user.getId(); 
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
		moviesButton.setForeground(Color.WHITE);
		moviesButton.setBackground(Color.DARK_GRAY);
		moviesButton.setBorder(null);
		moviesButton.setBounds(103, 17, 76, 29);
		moviesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		moviesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ExploreMoviesUI frame = new ExploreMoviesUI(user);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				ExploreMoviesUI.this.dispose();
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
				ExploreMoviesUI.this.dispose();
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
				ExploreMoviesUI.this.dispose();
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
				ExploreMoviesUI.this.dispose();
	    	}
	    });
	    profilePopup.add(menuItem);
	    profilePopup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		profilePopup.setBackground(new Color(31, 31, 31));
		navbar.add(userIcon);
		
        // Main Section
		allMovies = new AllMoviesDB();
			
        JScrollPane mainScrollPane = new JScrollPane();
        mainScrollPane.setBounds(0, 61, 1305, 572);
        contentPane.add(mainScrollPane);
        mainScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        mainScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(45, 0));
        mainScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        JPanel mainContent = new JPanel();
        mainContent.setPreferredSize(new Dimension(1300, 1415));
        mainScrollPane.setViewportView(mainContent);
        mainContent.setBackground(Color.WHITE);
        mainContent.setLayout(null);
        
		// Creating an instance of the user's vault
		MediaCollection collection = new MediaCollection(userId);
		// If the user has no movies in their vault, display default explore page
		if (collection.size() == 0) {
			// Add genre sections (separated by 355px each vertically)
			addGenreSection(mainContent, user, "Action", 8, 10);
			addGenreSection(mainContent, user, "Animation", 8, 365);
			addGenreSection(mainContent, user, "Drama", 8, 715);
			addGenreSection(mainContent, user, "Thriller", 8, 1065);
		} // If the user has movies in their vault, display recommended section with the rest of explore page
		else {
			List<Media> recommended = Recommendations.get(user, 8);
			addRecommended(mainContent, user, recommended, 10);
			addGenreSection(mainContent, user, "Action", 8, 365);
			addGenreSection(mainContent, user, "Animation", 8, 715);
			addGenreSection(mainContent, user, "Drama", 8, 1065);
		}
	}
	
	/**
	 * Used to create scrollable movie genre sections
	 * @param panel - the panel in which the sections should be added to
	 * @param userId - the userId of the current user
	 * @param genre - the genre to be added (first letter capitalized)
	 * @param yPosition - the starting y position of the section
	 */
	private void addGenreSection(JPanel panel, User user, String genre, int numOfMovies, int yPosition) {
	    JLabel label = new JLabel(genre.toUpperCase(), SwingConstants.CENTER);
	    label.setBounds(582, yPosition, 130, 22);
	    label.setFont(new Font("Lucida Grande", Font.BOLD, 19));
	    label.setBackground(Color.WHITE);
	    panel.add(label);
	    
	    JPanel content = new JPanel();
	    content.setBackground(Color.DARK_GRAY);
	    content.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
	    JScrollPane scrollPane = new JScrollPane(content);
	    
	    scrollPane.setViewportView(content);
	    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
	    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    scrollPane.setBounds(6, yPosition+34, 1275, 310);
	    panel.add(scrollPane);
	    JViewport viewport = scrollPane.getViewport();
	    
	    JButton leftButton = new JButton("<");
	    leftButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    leftButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
	    leftButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				Point origin = viewport.getViewPosition();
				Point newOrigin = new Point(origin.x-150, origin.y);
				if (origin.x != 0) { 
					viewport.setViewPosition(newOrigin);
				}
			}
		});
	    leftButton.setBorder(new LineBorder(new Color(0, 0, 0)));
	    leftButton.setBackground(Color.WHITE);
	    leftButton.setBounds(545, yPosition-2, 29, 29);
	    panel.add(leftButton);
	    
	    JButton rightButton = new JButton(">");
	    rightButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    rightButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
	    rightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Point origin = viewport.getViewPosition();
				Point newOrigin = new Point(origin.x+150, origin.y);
				viewport.setViewPosition(newOrigin);
			}
		});
	    rightButton.setBorder(new LineBorder(new Color(0, 0, 0)));
	    rightButton.setBackground(Color.WHITE);
	    rightButton.setBounds(720, yPosition-2, 29, 29);
	    panel.add(rightButton);
	    
	    try {
	    	int movieCount = 0;
	    	JButton[] moviePosters = new JButton[numOfMovies];
	    	for (int i = 0; i < allMovies.size() && movieCount < numOfMovies; i++) {
	    		if (allMovies.get(i).getGenre().equals(genre)) {
	        		String path = allMovies.get(i).getPosterPath();
	        		int id = allMovies.get(i).getId();
	    	        URL url = new URL(path);
	    			BufferedImage image = ImageIO.read(url);
	    			Image poster = new ImageIcon(image).getImage().getScaledInstance(225, 300, Image.SCALE_SMOOTH);
	    			
	        		moviePosters[movieCount] = new JButton(new ImageIcon(poster));
	        		moviePosters[movieCount].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        		moviePosters[movieCount].setBorder(null);
	        		moviePosters[movieCount].setBackground(Color.black);
	        		moviePosters[movieCount].addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							MoviePageUI frame = new MoviePageUI(user, new Movie(id));
							frame.setLocationRelativeTo(null);
	        		        frame.setVisible(true);
						}
	        		});
	    	        content.add(moviePosters[movieCount]);
	    	        
	        		movieCount++;
	    		}
	    	}
	        			        
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}

	/**
	 * Used to create a scrollable section for recommended movies
	 * @param panel - the panel in which the sections should be added to
	 * @param userId - the userId of the current user
	 * @param recommended - a list of recommended movies for the user
	 * @param yPosition - the starting y-position of the section
	 */
	private void addRecommended(JPanel panel, User user, List<Media> recommended, int yPosition) {
		JLabel label = new JLabel("RECOMMENDED");
	    label.setBounds(570, yPosition, 180, 22);
	    label.setFont(new Font("Lucida Grande", Font.BOLD, 19));
	    label.setBackground(Color.WHITE);
	    panel.add(label);
	    
	    JPanel content = new JPanel();
	    content.setBackground(Color.DARK_GRAY);
	    content.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
	    JScrollPane scrollPane = new JScrollPane(content);
	    
	    scrollPane.setViewportView(content);
	    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
	    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    scrollPane.setBounds(6, yPosition+34, 1275, 310);
	    panel.add(scrollPane);
	    JViewport viewport = scrollPane.getViewport();
	    
	    JButton leftButton = new JButton("<");
	    leftButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    leftButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
	    leftButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				Point origin = viewport.getViewPosition();
				Point newOrigin = new Point(origin.x-150, origin.y);
				if (origin.x != 0) { 
					viewport.setViewPosition(newOrigin);
				}
			}
		});
	    leftButton.setBorder(new LineBorder(new Color(0, 0, 0)));
	    leftButton.setBackground(Color.WHITE);
	    leftButton.setBounds(530, yPosition-2, 29, 29);
	    panel.add(leftButton);
	    
	    JButton rightButton = new JButton(">");
	    rightButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    rightButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
	    rightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Point origin = viewport.getViewPosition();
				Point newOrigin = new Point(origin.x+150, origin.y);
				viewport.setViewPosition(newOrigin);
			}
		});
	    rightButton.setBorder(new LineBorder(new Color(0, 0, 0)));
	    rightButton.setBackground(Color.WHITE);
	    rightButton.setBounds(735, yPosition-2, 29, 29);
	    panel.add(rightButton);
	    
	    try {
	    	for (Media media : recommended) {
	    		int id = media.getId();
	    		Movie movie = new Movie(id);
        		String path = movie.getPosterPath();
    	        URL url = new URL(path);
    			BufferedImage image = ImageIO.read(url);
    			Image poster = new ImageIcon(image).getImage().getScaledInstance(225, 300, Image.SCALE_SMOOTH);
    			
    			JButton moviePoster = new JButton(new ImageIcon(poster));
        		moviePoster.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        		moviePoster.setBorder(null);
        		moviePoster.setBackground(Color.black);
        		moviePoster.addActionListener(new ActionListener() {
        			@Override
        		    public void actionPerformed(ActionEvent e) {
        		        MoviePageUI frame = new MoviePageUI(user, new Movie(id));
        		        frame.setLocationRelativeTo(null);
        		        frame.setVisible(true);
        		    }
        		});
    	        content.add(moviePoster);
	    	}
	        			        
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
}