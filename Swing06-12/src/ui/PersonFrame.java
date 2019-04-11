package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import ui.model.Person;

import javax.swing.JButton;

public class PersonFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonFrame window = new PersonFrame();
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
	public PersonFrame() {
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Prenom :");
		lblNewLabel.setBounds(22, 38, 56, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(22, 99, 48, 28);
		frame.getContentPane().add(lblNom);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setBounds(22, 156, 56, 28);
		frame.getContentPane().add(lblAge);
		
		textField = new JTextField();
		textField.setBounds(114, 42, 155, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(292, 319, 89, 23);
		frame.getContentPane().add(btnModifier);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(114, 103, 155, 28);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(114, 160, 155, 28);
		frame.getContentPane().add(textField_2);
		
		Person person1 = new Person("Natalia", "MATHIEU", 18);
		
		textField.setText(person1.getPrenom());
		textField_1.setText(person1.getNom());
		textField_2.setText(String.valueOf(person1.getAge()));
		
		
		btnModifier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PersonDialog dialog = new PersonDialog(person1);
				dialog.setBounds(100, 100, 450, 300);
				dialog.setModal(true);
				dialog.setVisible(true);
				
				
				// ****************************
				//ça s'execute après le dialog
				
				textField.setText(dialog.getPerson().getPrenom());
				textField_1.setText(dialog.getPerson().getNom());
				textField_2.setText(String.valueOf(dialog.getPerson().getAge()));
			}
		});
		
		
		
	}

}
