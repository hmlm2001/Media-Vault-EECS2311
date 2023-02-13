package userinterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.BLACK);
		leftPanel.setBounds(0, 0, 400, 472);
		contentPane.add(leftPanel);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginButton.setBackground(Color.DARK_GRAY);
		loginButton.setBounds(525, 307, 137, 29);
		contentPane.add(loginButton);
		
		usernameField = new JTextField();
		usernameField.setBorder(new LineBorder(new Color(0, 0, 0)));
		usernameField.setBounds(437, 124, 325, 30);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel usernameLabel = new JLabel("USERNAME");
		usernameLabel.setBounds(437, 96, 77, 16);
		contentPane.add(usernameLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(0, 0, 0)));
		passwordField.setBounds(437, 229, 325, 30);
		contentPane.add(passwordField);
		
		JLabel passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setBounds(437, 201, 77, 16);
		contentPane.add(passwordLabel);
		
		JLabel textPrompt = new JLabel("Don't have an account?");
		textPrompt.setBounds(497, 395, 151, 16);
		contentPane.add(textPrompt);
		
		JButton signUpPrompt = new JButton("Sign Up");
		signUpPrompt.setForeground(Color.RED);
		signUpPrompt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		signUpPrompt.setBorder(null);
		signUpPrompt.setBounds(640, 392, 63, 23);
		contentPane.add(signUpPrompt);
	}
}
