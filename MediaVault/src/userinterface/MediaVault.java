package userinterface;

import java.awt.EventQueue;

import backend.UseStub;

public class MediaVault {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//Switch to true to use stub DB
		UseStub.setStubFlag(false);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
