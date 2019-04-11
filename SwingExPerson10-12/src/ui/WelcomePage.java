package ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private String klass;

	

	/**
	 * Create the application.
	 */
	public WelcomePage() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
	//	frame.setBounds(100, 100, 450, 300); //en comm, car précisé dans PersonFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
getContentPane().setLayout(null);
		
		JLabel lblChoisirLaBdd = new JLabel("Choisir la BDD");
		lblChoisirLaBdd.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		lblChoisirLaBdd.setBounds(158, 55, 127, 14);
		getContentPane().add(lblChoisirLaBdd);
		
		JButton btnUtiliserMysql = new JButton("Utiliser MySQL");
		btnUtiliserMysql.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 12));
		btnUtiliserMysql.setBounds(44, 112, 145, 23);
		getContentPane().add(btnUtiliserMysql);
		
		JButton btnUtilisermongodb = new JButton("UtiliserMongoDB");
		btnUtilisermongodb.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 12));
		btnUtilisermongodb.setBounds(225, 112, 156, 23);
		getContentPane().add(btnUtilisermongodb);
		
		
		btnUtiliserMysql.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				klass = "Utiliser MySQL";
				dispose();
			}
		});
		
		
		btnUtilisermongodb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				klass = "Utiliser MongoDB";
				dispose();
			}
		});
	
	}
	
	
}
