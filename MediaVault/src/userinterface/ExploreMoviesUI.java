package userinterface;

import persistence.*;

import java.awt.Image;
import java.awt.Point;

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
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class ExploreMoviesUI extends JFrame {

	private JPanel contentPane;
	private MovieDB allMovies;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExploreMoviesUI frame = new ExploreMoviesUI();
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
		
		allMovies = new MovieDB();
			
        JScrollPane mainScrollPane = new JScrollPane();
        mainScrollPane.setBounds(0, 101, 1300, 571);
        contentPane.add(mainScrollPane);
        mainScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        mainScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        JPanel mainContent = new JPanel();
        mainContent.setPreferredSize(new Dimension(1300, 1000));
        mainScrollPane.setViewportView(mainContent);
        mainContent.setBackground(Color.WHITE);
        mainContent.setLayout(null);
        
        // Action Movies
        JLabel actionLabel = new JLabel("ACTION");
        actionLabel.setBounds(605, 6, 78, 22);
        actionLabel.setFont(new Font("Lucida Grande", Font.BOLD, 19));
        actionLabel.setBackground(Color.WHITE);
        mainContent.add(actionLabel);
        
        JScrollPane actionScrollPane = new JScrollPane();
        actionScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        actionScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        actionScrollPane.setBounds(6, 40, 1275, 300);
        mainContent.add(actionScrollPane);
        JViewport viewport = actionScrollPane.getViewport();
        
        JPanel actionContent = new JPanel();
        actionContent.setPreferredSize(new Dimension(3412, 270));
        actionScrollPane.setViewportView(actionContent);
        actionContent.setBackground(Color.WHITE);
        actionContent.setLayout(null);
        
        JButton actionLeftButton = new JButton("<");
        actionLeftButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        actionLeftButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
        actionLeftButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				Point origin = viewport.getViewPosition();
				Point newOrigin = new Point(origin.x-150, origin.y);
				if (origin.x != 0) { 
					viewport.setViewPosition(newOrigin);
				}
			}
		});
        actionLeftButton.setBorder(new LineBorder(new Color(0, 0, 0)));
        actionLeftButton.setBackground(Color.DARK_GRAY);
        actionLeftButton.setBounds(555, 4, 29, 29);
        mainContent.add(actionLeftButton);
        
        JButton actionRightButton = new JButton(">");
        actionRightButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        actionRightButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
        actionRightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Point origin = viewport.getViewPosition();
				Point newOrigin = new Point(origin.x+150, origin.y);
				viewport.setViewPosition(newOrigin);
			}
		});
        actionRightButton.setBorder(new LineBorder(new Color(0, 0, 0)));
        actionRightButton.setBackground(Color.DARK_GRAY);
        actionRightButton.setBounds(705, 4, 29, 29);
        mainContent.add(actionRightButton);
        
        try {
        	int movieCount = 0;
        	int xPosition = 1;
        	JLabel[] actionMoviePosters = new JLabel[15];
        	JLabel[] actionMovieLabels = new JLabel[15];
        	for (int i = 0; i < allMovies.size() && movieCount < 15; i++) {
        		if (allMovies.get(i).getGenre().equals("Action")) {
        			String title = allMovies.get(i).getTitle();
	        		String path = allMovies.get(i).getPosterPath();
	        		int id = allMovies.get(i).getId();
	    	        URL url = new URL(path);
	    			BufferedImage image = ImageIO.read(url);
	    			Image poster = new ImageIcon(image).getImage().getScaledInstance(195, 265, Image.SCALE_SMOOTH);
	    			
	        		actionMoviePosters[movieCount] = createMoviePoster(new ImageIcon(poster), xPosition, 0);
	        		actionMoviePosters[movieCount].addMouseListener(new MyMouseAdapter(id));
	        		actionMovieLabels[movieCount] = createMovieLabel(title, xPosition, 270);
	    	        actionContent.add(actionMoviePosters[movieCount]);
	    	        actionContent.add(actionMovieLabels[movieCount]);
	    	        
	    	        xPosition += 230;
	        		movieCount++;
        		}
        	}
	        			        
        } catch (Exception e) {
        	e.printStackTrace();
        }
	    
	}
	
	private JLabel createMoviePoster(ImageIcon img, int x, int y) {
		JLabel moviePoster = new JLabel(img);
		moviePoster.setBounds(x, y, 190, 265);
		moviePoster.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		return moviePoster;
	}
	
	private JLabel createMovieLabel(String title, int x, int y) {
		JLabel movieLabel = new JLabel(title, SwingConstants.CENTER);
		movieLabel.setBounds(x, y, 190, 20);
		movieLabel.setForeground(Color.BLACK);
		movieLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        movieLabel.setBackground(Color.WHITE);
		return movieLabel;
	}
}

class MyMouseAdapter extends MouseAdapter {
	private int movieId;
	public MyMouseAdapter(int id) {
		this.movieId = id;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		MoviePageUI frame = new MoviePageUI(new Movie(movieId));
    	frame.setLocationRelativeTo(null);
    	frame.toFront();
    	frame.requestFocus();
		frame.setVisible(true);
	}
}
