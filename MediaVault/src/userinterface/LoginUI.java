package userinterface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import backend.User;
import userinterface.swing.MyActionListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public LoginUI() {
		setTitle("MediaVault");
		setResizable(false);	      
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.DARK_GRAY);
		leftPanel.setBounds(0, -17, 400, 489);
		contentPane.add(leftPanel);
		
		JLabel mediaVaultLogo = new JLabel("");
		leftPanel.add(mediaVaultLogo);
		mediaVaultLogo.setIcon(new ImageIcon(LoginUI.class.getResource("/images/logos/mv-logo-white-with-text-no-bg.png")));
		mediaVaultLogo.setForeground(Color.WHITE);
		
		JLabel successPrompt = new JLabel("");
		contentPane.add(successPrompt);
		
		usernameField = new JTextField();
		usernameField.setBorder(new LineBorder(new Color(0, 0, 0)));
		usernameField.setBounds(439, 140, 325, 30);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel usernameLabel = new JLabel("USERNAME");
		usernameLabel.setBounds(439, 112, 77, 16);
		contentPane.add(usernameLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(0, 0, 0)));
		passwordField.setBounds(439, 228, 325, 30);
		contentPane.add(passwordField);
		
		JLabel passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setBounds(439, 200, 77, 16);
		contentPane.add(passwordLabel);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBorder(new LineBorder(Color.BLACK, 1, true));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				
				if (backend.Login.login(username, password)) {
					User user = new User(username);
					successPrompt.setForeground(new Color(52, 200, 15));
					successPrompt.setBounds(550, 343, 110, 16);
					successPrompt.setText("Logging in...");
					Timer t = new Timer(0, new MyActionListener(user.getId()) {
					    public void actionPerformed(ActionEvent e) {
					    	ExploreMoviesUI frame = new ExploreMoviesUI(userId);
					    	frame.setLocationRelativeTo(null);
							frame.setVisible(true);
							LoginUI.this.dispose();
					    }
					});
					t.setRepeats(false);
					t.start();
				} else {
					successPrompt.setForeground(Color.RED);
					successPrompt.setBounds(480, 343, 250, 16);
					successPrompt.setText("Invalid username/password. Try again.");
				}
			}
		});
		loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginButton.setBackground(Color.WHITE);
		loginButton.setBounds(528, 303, 137, 29);
		contentPane.add(loginButton);
		
		JLabel textPrompt = new JLabel("Don't have an account?");
		textPrompt.setBounds(498, 417, 151, 16);
		contentPane.add(textPrompt);
		
		JButton signUpPrompt = new JButton("<HTML><U>Sign Up</U></HTML>");
		signUpPrompt.setBackground(Color.WHITE);
		signUpPrompt.setCursor(new Cursor(Cursor.HAND_CURSOR));
		signUpPrompt.setForeground(Color.BLUE);
		signUpPrompt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpUI frame = new SignUpUI();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				LoginUI.this.dispose();
			}
		});
		signUpPrompt.setBorder(null);
		signUpPrompt.setBounds(643, 414, 57, 23);
		contentPane.add(signUpPrompt);
	}
}
