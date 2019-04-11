package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class ButtonTextSwitch {

	private JFrame frame;
	private boolean on = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ButtonTextSwitch window = new ButtonTextSwitch();
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
	public ButtonTextSwitch() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(33, 21, 370, 216);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnClickMe = new JButton("Click me!");
		btnClickMe.setBounds(135, 90, 130, 23);
		panel.add(btnClickMe);

		/*
		 * btnClickMe.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) {
		 * 
		 * String text = (String)e.getActionCommand();
		 * 
		 * if(text.equals("Click me!")) { btnClickMe.setText("Once again!");
		 * 
		 * } else {
		 * 
		 * btnClickMe.setText("Click me!"); } } });
		 */

		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (on) {
					btnClickMe.setText("Click me!");
					on = false;
				} else {
					btnClickMe.setText("Once again");
					on = true;
				}
			}
			
		});
	}

}
