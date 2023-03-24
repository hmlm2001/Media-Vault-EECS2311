package userinterface;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.border.EmptyBorder;

import backend.*;
import persistence.AllMoviesDB;
import userinterface.swing.*;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class VaultUI extends JFrame{
	private JPanel contentPane;
	private MyTextField searchbar;
	private JPopupMenu menu;
    private PanelSearch search;
    private AllMoviesDB allMovies;
    private JPopupMenu popup;
    private JButton status;
    private JPanel moviepane;
    
    /**
     * Displays all movies the user has added to their vault.
     * uses the frame with the same navigation bar as the explore page. 
     * @param userId the id of the user currently logged in
     */
	
	public VaultUI (User user) {
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
				ExploreMoviesUI frame = new ExploreMoviesUI(user);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				VaultUI.this.dispose();
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
		vaultButton.setBorder(null);
		vaultButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		vaultButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VaultUI frame = new VaultUI(user);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				VaultUI.this.dispose();
			}
		});
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
				VaultUI.this.dispose();
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
                
                MoviePageUI frame = new MoviePageUI(user, new Movie(movie.getId()));
            	frame.setLocationRelativeTo(null);
        		frame.setVisible(true);
            }
        });
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 61, 1280, 600);
		contentPane.add(layeredPane);
		
		JPanel panel = new JPanel();
		layeredPane.setLayer(panel, 1);
		panel.setForeground(new Color(192, 192, 192));
		panel.setBackground(new Color(31, 31, 31));
		panel.setBounds(0, 37, 1, 1000);
		
		addMediaButtons(panel, user);
		panel.setLayout(new FlowLayout());
		
	
		JScrollPane scrollPane_1 = new JScrollPane(panel);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		scrollPane_1.setBounds(0, 40, 1284, 550);
		layeredPane.add(scrollPane_1);
		
		JLabel userLabel = new JLabel("This is your vault, " + user.getUsername());
		userLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		userLabel.setBounds(6, 9, 422, 16);
		layeredPane.add(userLabel);
	
	}
	/**
	 * iterates through the user's vault and adds each movie to the display panel
	 * @param panel the panel to display movies
	 * @param userId the id of the user currently logged in
	 */
	
private void addMediaButtons(JPanel panel, User user) {
		
		UseStub.setStubFlag(false);
		Movie movie;		
		JButton mediaButton;
		JButton removeButton;
		
		
		JMenuItem menuItem;
		
		
		MediaCollection collection = new MediaCollection(user.getId());
		ArrayList<backend.Media> mediaList = collection.getMediaList();
		ArrayList<String> statusList = new ArrayList<String>(collection.size());
		
		URL url;
		BufferedImage c;
		int i = collection.size();
		
		if (collection.size() == 0) {
			JLabel emptyVaultLabel = new JLabel("Nothing to see here...Search for movies and add them to your vault!");
			emptyVaultLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			emptyVaultLabel.setForeground(Color.WHITE);
			panel.add(emptyVaultLabel);
		} else {
			int index = 0;
			for(backend.Media media: mediaList) {
				
				moviepane = new JPanel();
				moviepane.setBounds(0, 0, 100, 200);				
				moviepane.setForeground(new Color(192, 192, 192));
				moviepane.setBackground(new Color(31, 31, 31));
				moviepane.setLayout(new GridBagLayout());
				
				GridBagConstraints constraints = new GridBagConstraints();
				constraints.fill = GridBagConstraints.HORIZONTAL;
				
				mediaButton = new JButton(media.getTitle());
				removeButton = new JButton("remove");
				
				movie = new Movie(media.getId());				
				
				try {				
					url = new URL(movie.getPosterPath());
					c = ImageIO.read(url);
					mediaButton.setIcon(new ImageIcon(c.getScaledInstance(350, 470, 0)));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				mediaButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						MoviePageUI frame = new MoviePageUI(user, new Movie(media.getId()));
						frame.setLocationRelativeTo(null);
        		        frame.setVisible(true);
					}
        		});
				
				mediaButton.setText(null);
				mediaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				mediaButton.setBackground(Color.black);
				mediaButton.setBorder(null);
				mediaButton.setBounds(0, 0, 100, 200);
				
				constraints.fill = GridBagConstraints.HORIZONTAL;
				constraints.gridwidth = 4;
				constraints.gridx=0;
				constraints.gridy = 0;
				moviepane.add(mediaButton,constraints);
				
				
				Image removeIcon = new ImageIcon(getClass().getResource("/images/icons/remove.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				removeButton.setIcon(new ImageIcon(removeIcon));
				removeButton.setPreferredSize(new Dimension(30,30));
			
				removeButton.setText(null);
				removeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				removeButton.setBackground(new Color(31, 31, 31));
				removeButton.setBorder(null);
				removeButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						collection.removeMedia(media.getId());
						VaultUI frame = new VaultUI(user);
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
						VaultUI.this.dispose();
					}
				});
				//constraints.fill = GridBagConstraints.HORIZONTAL;
				constraints.gridwidth = 1;
				constraints.weightx = 0.1;
				constraints.gridx=3;
				constraints.gridy = 1;
				constraints.insets = new Insets(10,0,10,0);	
				constraints.anchor = GridBagConstraints.CENTER;
				
				moviepane.add(removeButton, constraints);
				JLabel selection = new JLabel(media.getStatus());
				//JLabel selection = new JLabel(media.getStatus());
				selection.setBackground(new Color(31, 31, 31));
				selection.setBorder(null);
				selection.setForeground(Color.WHITE);
				selection.setVisible(true);
				
				statusList.add(media.getStatus());
				
			
			    //Create the popup menu.
			    popup = new JPopupMenu();
			    
			    status = new JButton();
			    
			    
			    //status.setText(media.getStatus);
			    status.setText("STATUS");
				status.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				status.setBackground(new Color(31, 31, 31));
				status.setBorder(null);
				status.setForeground(Color.WHITE);
				
			    MouseListener popupListener = new PopupListener();
			    status.addMouseListener(popupListener);
			    
			    
			    menuItem = new JMenuItem("Yet to Watch");
			    menuItem.setBackground(new Color(31, 31, 31));
				menuItem.setBorder(null);
				menuItem.setForeground(Color.WHITE);
			    menuItem.addActionListener(new ActionListener() {
			    	@Override
			    	public void actionPerformed(ActionEvent e) {
			    		collection.setStatus(media.getId(),"Yet to Watch");
			    		//statusList.set(index++, "Yet to watch");
			    		selection.setText("Yet to Watch");
			    		SwingUtilities.updateComponentTreeUI(selection);
			    	}
			    });
			    popup.add(menuItem);
			    menuItem = new JMenuItem("Completed");
			    menuItem.setBackground(new Color(31, 31, 31));
				menuItem.setBorder(null);
				menuItem.setForeground(Color.WHITE);
			    menuItem.addActionListener(new ActionListener() {
			    	@Override
			    	public void actionPerformed(ActionEvent e) {
			    		collection.setStatus(media.getId(),"Completed");
			    		//status.setText("Completed");
			    		selection.setText("Completed");
			    		SwingUtilities.updateComponentTreeUI(selection);
			    	}
			    });
			    popup.add(menuItem);
			    
			    menuItem = new JMenuItem("In Progress");
			    menuItem.setBackground(new Color(31, 31, 31));
				menuItem.setBorder(null);
				menuItem.setForeground(Color.WHITE);
			    menuItem.addActionListener(new ActionListener() {
			    	@Override
			    	public void actionPerformed(ActionEvent e) {
			    		collection.setStatus(media.getId(),"In Progress");			    		
			    		selection.setText("In Progress");			    		
			    		selection.setVisible(true);
			    		moviepane.setVisible(false);
			    		SwingUtilities.updateComponentTreeUI(selection);
			    		moviepane.setVisible(true);
			    		//SwingUtilities.updateComponentTreeUI(moviepane);
			    	}
			    });
			    popup.add(menuItem);
			    
			    
			    popup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				popup.setBackground(new Color(31, 31, 31));
				popup.setBorder(null);
			    
			    
			    
			    
				//constraints.fill = GridBagConstraints.HORIZONTAL;
				constraints.gridwidth = 1;
				constraints.weightx = 0.3;
				constraints.gridx=1;
				constraints.gridy = 1;
				constraints.insets = new Insets(10,0,10,0);
				constraints.anchor = GridBagConstraints.EAST;
				
				moviepane.add(status, constraints);
				status.setVisible(false);
	    		status.setVisible(true);
				
				
			
				constraints.gridwidth = 1;
				constraints.weightx = 0.6;
				constraints.gridx=2;
				constraints.gridy = 1;
				constraints.insets = new Insets(10,0,10,0);
				
				
				
				moviepane.add(selection,constraints);
				
				panel.add(moviepane);
				//panel.add(mediaButton);
				
			}
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
    
    public class PopupListener extends MouseAdapter{
    	public void mousePressed(MouseEvent e) {
            ShowPopup(e);
        }
    	private void ShowPopup(MouseEvent e) {    		
    			popup.show(e.getComponent(),
                       e.getX(), e.getY());
    		
        }
    }
}
