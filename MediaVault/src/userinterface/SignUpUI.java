package userinterface;
import backend.Login;
import backend.User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SignUpUI extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpUI frame = new SignUpUI();
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
	public SignUpUI() {
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
		usernameField.setBounds(437, 75, 325, 30);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel usernameLabel = new JLabel("USERNAME");
		usernameLabel.setBounds(437, 47, 77, 16);
		contentPane.add(usernameLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(0, 0, 0)));
		passwordField.setBounds(437, 163, 325, 30);
		contentPane.add(passwordField);
		
		JLabel passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setBounds(437, 135, 77, 16);
		contentPane.add(passwordLabel);
		
		JButton signUpButton = new JButton("Sign Up");
		signUpButton.setBorder(new LineBorder(Color.BLACK, 1, true));
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				String confirmPassword = new String(confirmPasswordField.getPassword());
				
				if (username.equals("") || password.equals("")) {
					successPrompt.setForeground(Color.RED);
					successPrompt.setBounds(480, 350, 250, 16);
					successPrompt.setText("Username/Password can not be empty.");
				} else if (!password.equals(confirmPassword)) {
					successPrompt.setForeground(Color.RED);
					successPrompt.setBounds(490, 350, 250, 16);
					successPrompt.setText("Passwords do not match. Try again.");
				} else if (backend.Login.createAccount(username, password)) {
					User user = new User(username); // for now
					successPrompt.setForeground(new Color(52, 200, 15));
					successPrompt.setBounds(535, 350, 150, 16);
					successPrompt.setText("Sign up successful!");
					Timer t = new Timer(1000, new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					    	ExploreUI frame = new ExploreUI();
					    	frame.setLocationRelativeTo(null);
							frame.setVisible(true);
							SignUpUI.this.dispose();
					    }
					});
					t.setRepeats(false);
					t.start();
				} else {
					successPrompt.setForeground(Color.RED);
					successPrompt.setBounds(535, 350, 250, 16);
					successPrompt.setText("User already exists.");
				}
			}
		});
		signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		signUpButton.setBackground(Color.WHITE);
		signUpButton.setBounds(529, 310, 137, 29);
		contentPane.add(signUpButton);
		
		JLabel textPrompt = new JLabel("Already have an account?");
		textPrompt.setBounds(498, 417, 164, 16);
		contentPane.add(textPrompt);
		
		JButton loginPrompt = new JButton("<HTML><U>Login</U></HTML>");
		loginPrompt.setBackground(Color.WHITE);
		loginPrompt.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginPrompt.setForeground(Color.BLUE);
		loginPrompt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUI frame = new LoginUI();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				SignUpUI.this.dispose();
			}
		});
		loginPrompt.setBorder(null);
		loginPrompt.setBounds(650, 414, 57, 23);
		contentPane.add(loginPrompt);
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBorder(new LineBorder(new Color(0, 0, 0)));
		confirmPasswordField.setBounds(437, 249, 325, 30);
		contentPane.add(confirmPasswordField);
		
		JLabel confirmPasswordLabel = new JLabel("CONFIRM PASSWORD");
		confirmPasswordLabel.setBounds(437, 221, 137, 16);
		contentPane.add(confirmPasswordLabel);
	}
}
