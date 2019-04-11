package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JLabel;

public class MyFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame window = new MyFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnClickHere = new JButton("Click here");
		btnClickHere.setBounds(270, 302, 128, 23);
		frame.getContentPane().add(btnClickHere);
		
		btnClickHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MyDialog dialog = new MyDialog();
				dialog.setBounds(100, 100, 400, 250);
				dialog.setModal(true);
				dialog.setVisible(true);
				
				
			}
		});
		
		JLabel lblMainWindow = new JLabel("Main window");
		lblMainWindow.setBounds(285, 69, 79, 14);
		frame.getContentPane().add(lblMainWindow);
		
		
	}
}
