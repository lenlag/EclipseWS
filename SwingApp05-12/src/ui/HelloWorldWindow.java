package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class HelloWorldWindow {

	private JFrame frmEssai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloWorldWindow window = new HelloWorldWindow();
					window.frmEssai.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HelloWorldWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEssai = new JFrame();
		frmEssai.setTitle("Essai");
		frmEssai.setBounds(100, 100, 450, 300);
		frmEssai.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // en cliquant sur x, ça arrete tous les processus + l'application. on ferme pas simplement la fenetre, mais toute l'appli
		frmEssai.getContentPane().setLayout(null); // null = absolute layout
		
		JLabel lblNewLabel = new JLabel("Hello, World");
		lblNewLabel.setBounds(45, 81, 309, 56);
		frmEssai.getContentPane().add(lblNewLabel);
	}

}
