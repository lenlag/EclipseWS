package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;

public class ButtonGetTextFromField {

	private JFrame frame;
	private JTextField txtWatch;
	private JTextField textField_1;
	private JTextField txtModernWatchFor;
	private int i = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ButtonGetTextFromField window = new ButtonGetTextFromField();
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
	public ButtonGetTextFromField() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(47, 51, 339, 152);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblFirstName = new JLabel("Item :");
		lblFirstName.setBounds(22, 11, 86, 20);
		panel.add(lblFirstName);
		
		txtWatch = new JTextField();
		txtWatch.setText("Watch");
		txtWatch.setBounds(118, 11, 86, 20);
		panel.add(txtWatch);
		txtWatch.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setBounds(22, 45, 46, 14);
		panel.add(lblPrice);
		
		textField_1 = new JTextField();
		textField_1.setText("$ 50.00");
		textField_1.setBounds(118, 42, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDetails = new JLabel("Details :");
		lblDetails.setBounds(22, 77, 46, 14);
		panel.add(lblDetails);
		
		txtModernWatchFor = new JTextField();
		txtModernWatchFor.setText("modern watch for a fashion girl");
		txtModernWatchFor.setBounds(118, 73, 195, 31);
		panel.add(txtModernWatchFor);
		txtModernWatchFor.setColumns(10);
		
		JButton btnAddToCart = new JButton("Add to cart");
		btnAddToCart.setBounds(52, 129, 120, 23);
		panel.add(btnAddToCart);
		
		btnAddToCart.addActionListener(new ActionListener() { // on rajoute Listener(comme on-click event)
			public void actionPerformed(ActionEvent e) {
			System.out.println(txtWatch.getText() +" " + textField_1.getText() + " " + txtModernWatchFor.getText() + " " + i++);
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(186, 129, 89, 23);
		panel.add(btnBack);
	}
}
