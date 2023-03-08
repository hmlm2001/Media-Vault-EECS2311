package userinterface;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.EmptyBorder;

import backend.MediaCollection;
import backend.Movie;
import backend.UseStub;
import backend.User;
import persistence.AllMoviesDB;
import persistence.MediaCollectionDB;
import persistence.MovieDB;
import persistence.UserDB;
import userinterface.swing.EventClick;
import userinterface.swing.MyMouseAdapter;
import userinterface.swing.MyTextField;
import userinterface.swing.PanelSearch;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;

@SuppressWarnings("serial")
public class MediaCollectionUI  extends JFrame{
	private JPanel contentPane;
	private MyTextField searchbar;
	private User user;
	private JPopupMenu menu;
    private PanelSearch search;
    private AllMoviesDB allMovies;
	
	public MediaCollectionUI () {
		allMovies = new AllMoviesDB();
		setTitle("MediaVault");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 660);
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
		moviesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExploreMoviesUI frame = new ExploreMoviesUI();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		moviesButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				moviesButton.setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent e) {
				moviesButton.setForeground(Color.GRAY);
			}
		});
		moviesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		moviesButton.setForeground(Color.GRAY);
		moviesButton.setBackground(Color.DARK_GRAY);
		moviesButton.setBorder(null);
		moviesButton.setBounds(103, 17, 76, 29);
		navbar.add(moviesButton);
		
		JButton vaultButton = new JButton("VAULT");
		
		vaultButton.setForeground(Color.WHITE);
		vaultButton.setBackground(Color.DARK_GRAY);
		vaultButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		vaultButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MediaCollectionUI frame = new MediaCollectionUI();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
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
				MediaCollectionUI.this.dispose();
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
                
                MoviePageUI frame = new MoviePageUI(new Movie(movie.getId()));
            	frame.setLocationRelativeTo(null);
            	frame.toFront();
            	frame.requestFocus();
        		frame.setVisible(true);
            }
        });
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 61, 1280, 600);
		contentPane.add(layeredPane);
		
		JButton WatchListVault = new JButton("   VAULT");
		WatchListVault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		layeredPane.setLayer(WatchListVault, 1);
		WatchListVault.setHorizontalAlignment(SwingConstants.LEADING);
		WatchListVault.setForeground(new Color(255, 255, 255));
		WatchListVault.setFont(new Font("Georgia", Font.BOLD, 22));
		WatchListVault.setBackground(new Color(31, 31, 31));
		WatchListVault.setBorder(null);
		WatchListVault.setBounds(0, 0, 1282, 73);
		layeredPane.add(WatchListVault);
		
		JPanel panel = new JPanel();
		layeredPane.setLayer(panel, 1);
		panel.setForeground(new Color(192, 192, 192));
		panel.setBackground(new Color(31, 31, 31));
		panel.setBounds(0, 37, 1, 1000);
		
		addMediaButtons(panel);
		//panel.setLayout(new GridLayout(0, 3 , 20, 20));
		panel.setLayout(new FlowLayout());
		//layeredPane.add(panel);
	
		JScrollPane scrollPane_1 = new JScrollPane(panel);
		scrollPane_1.setBounds(0, 70, 1284, 600);
		layeredPane.add(scrollPane_1);
	
	}
	
	
	private void addMediaButtons(JPanel panel ) {
		
		Movie movie;
		UseStub.setStubFlag(false);
		// for when it is connected
		//int id = this.user.getId();
		//MediaCollection collection = new MediaCollection(id);
		
		MediaCollection collection = new MediaCollection(4);
		ArrayList<backend.Media> mediaList = collection.getMediaList();
		JButton mediaButton; 
		URL url;
		BufferedImage c;
		
		for(backend.Media media: mediaList) {
			
			mediaButton = new JButton(media.getTitle());
			
			movie = new Movie(media.getId());
			
			
			try {				
				url = new URL(movie.getPosterPath());
				c = ImageIO.read(url);
				mediaButton.setIcon(new ImageIcon(c.getScaledInstance(350, 470, 0)));
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			mediaButton.addMouseListener(new MyMouseAdapter(media.getId()));
				
			
			mediaButton.setText(null);
			mediaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			mediaButton.setBackground(Color.black);
			mediaButton.setBorder(null);
			panel.add(mediaButton);
			
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
