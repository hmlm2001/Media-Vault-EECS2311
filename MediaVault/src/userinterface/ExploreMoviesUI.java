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
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
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
	private MyTextField searchbar;
	private JPopupMenu menu;
    private PanelSearch search;
    
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//Switch to true to use stub DB
		UseStub.setStubFlag(false);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExploreMoviesUI frame = new ExploreMoviesUI(10);
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
	public ExploreMoviesUI(int userId) {
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
		
		JLabel mediaVaultLogo = new JLabel("");
		mediaVaultLogo.setHorizontalAlignment(SwingConstants.CENTER);
		Image mv_logo = new ImageIcon(getClass().getResource("/images/logos/mv-logo-white-with-text-no-bg.png")).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
		mediaVaultLogo.setIcon(new ImageIcon(mv_logo));
		mediaVaultLogo.setBounds(3, 6, 88, 59);
		navbar.add(mediaVaultLogo);
		
		JButton moviesButton = new JButton("MOVIES");
		moviesButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		moviesButton.setForeground(Color.WHITE);
		moviesButton.setBackground(Color.DARK_GRAY);
		moviesButton.setBorder(null);
		moviesButton.setBounds(103, 17, 76, 29);
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
		vaultButton.addActionListener(new MyActionListener(userId) {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VaultUI frame = new VaultUI(userId);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				ExploreMoviesUI.this.dispose();
			}
		});
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
		
		// Searchbar
		searchbar = new MyTextField();
		searchbar.setBounds(520, 13, 550, 40);
		navbar.add(searchbar);
		searchbar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		searchbar.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png")));
		searchbar.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        txtSearchMouseClicked(evt);
		    }
		});
		searchbar.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyReleased(java.awt.event.KeyEvent evt) {
		        txtSearchKeyReleased(evt);
		    }
		});
		
		menu = new JPopupMenu();
        search = new PanelSearch();
        menu.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        menu.add(search);
        menu.setFocusable(false);
        search.addEventClick(new EventClick() {
            @Override
            public void itemClick(Movie movie) {
                menu.setVisible(false);
                searchbar.setText(movie.getTitle());
                
                MoviePageUI frame = new MoviePageUI(userId, new Movie(movie.getId()));
            	frame.setLocationRelativeTo(null);
            	frame.toFront();
            	frame.requestFocus();
        		frame.setVisible(true);
            }
        });
        
        // Main Section
		allMovies = new AllMoviesDB();
			
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
        
        JLabel userLabel = new JLabel("Welcome to MediaVault, " + UserDB.getUsername(userId));
		userLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		userLabel.setBounds(6, 9, 422, 16);
		mainContent.add(userLabel);
		
		// Creating an instance of the user's vault
		MediaCollection collection = new MediaCollection(userId);
		// If the user has no movies in their vault, display default explore page
		if (collection.size() == 0) {
			// Add genre sections (separated by 355px each vertically)
			addGenreSection(mainContent, userId, "Action", 8, 10);
			addGenreSection(mainContent, userId, "Animation", 8, 365);
			addGenreSection(mainContent, userId, "Drama", 8, 715);
			addGenreSection(mainContent, userId, "Thriller", 8, 1065);
		} // If the user has movies in their vault, display recommended section with the rest of explore page
		else {
			List<Media> recommended = new ArrayList<>();
			recommended.add(new Movie(411));
			recommended.add(new Movie(19995));
			addRecommended(mainContent, userId, recommended, 10);
			addGenreSection(mainContent, userId, "Action", 8, 365);
			addGenreSection(mainContent, userId, "Animation", 8, 715);
			addGenreSection(mainContent, userId, "Drama", 8, 1065);
		}
	}
	
	/**
	 * Used to create scrollable movie genre sections
	 * @param panel - the panel in which the sections should be added to
	 * @param userId - the userId of the current user
	 * @param genre - the genre to be added (first letter capitalized)
	 * @param yPosition - the starting y position of the section
	 */
	private void addGenreSection(JPanel panel, int userId, String genre, int numOfMovies, int yPosition) {
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
	        		moviePosters[movieCount].addMouseListener(new MyMouseAdapter(userId, id));
	    	        content.add(moviePosters[movieCount]);
	    	        
	        		movieCount++;
	    		}
	    	}
	        			        
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	// TODO: ADD JAVADOC
	private void addRecommended(JPanel panel, int userId, List<Media> recommended, int yPosition) {
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
        		moviePoster.addMouseListener(new MyMouseAdapter(userId, id));
    	        content.add(moviePoster);
	    	}
	        			        
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	/**
	 * Used to show the menu when the searchbar is clicked
	 * @param evt - occurs when the mouse is clicked
	 */
	private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {
        if (search.getItemSize() > 0) {
            menu.show(searchbar, 0, searchbar.getHeight());
        }
    }
	
	/**
	 * Used to search the database when a key is pressed
	 * @param evt - occurs when a key is released
	 */
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {
        String text = searchbar.getText().trim().toLowerCase();
        search.setMovies(search(text));
        if (search.getItemSize() > 0) {
            menu.show(searchbar, 0, searchbar.getHeight());
            menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
        } else {
            menu.setVisible(false);
        }
    }

    /**
     * Used to search through all the movies database 
     * @param search - the title to be searched for
     * @return a list of movies with titles containing the search query
     */
    private List<Movie> search(String search) {
    	int limitData = 10;
        List<Movie> list = new ArrayList<>();
        for (int i = 0; i < allMovies.size(); i++) {
        	if (allMovies.get(i).getTitle().toLowerCase().contains(search)) {
            	list.add(allMovies.get(i));
            	
                if (list.size() == limitData) {
                    break;
                }
            }
        }
        return list;
    }
}