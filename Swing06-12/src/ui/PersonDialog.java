package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.model.Person;

import javax.swing.JButton;

public class PersonDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Person person;
	                                                
	
	// on a supprimé le main, car on lance cette fenetre depuis PersonFrame
	

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * Create the application.
	 */
	public PersonDialog(Person person) { // on mets Person dans le paramètre
		this.person = person;
		initialize(person); // et on le passe à initialize
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Person person) { //on mets Person dans les paramètres d'initialize
				
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
	

		JLabel lblNewLabel = new JLabel("Modifiez prenom :");
		lblNewLabel.setBounds(10, 29, 113, 23);
		getContentPane().add(lblNewLabel);

		JLabel lblNouveauNom = new JLabel("Modifiez nom :");
		lblNouveauNom.setBounds(10, 63, 113, 23);
		getContentPane().add(lblNouveauNom);

		JLabel lblNouvelleAge = new JLabel("Modifiez age :");
		lblNouvelleAge.setBounds(10, 97, 113, 23);
		getContentPane().add(lblNouvelleAge);

		textField = new JTextField();
		textField.setBounds(133, 30, 134, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(person.getPrenom());

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(133, 64, 134, 20);
		getContentPane().add(textField_1);
		textField_1.setText(person.getNom());

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(133, 98, 134, 20);
		getContentPane().add(textField_2);
		textField_2.setText(String.valueOf(person.getAge()));

		JButton btnOK = new JButton("OK");
		btnOK.setBounds(34, 187, 89, 23);
		getContentPane().add(btnOK);

		JButton btnAnnul = new JButton("Annuler");
		btnAnnul.setBounds(194, 187, 89, 23);
		getContentPane().add(btnAnnul);

			
		btnAnnul.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String newPrenom = textField.getText();
				String newNom = textField_1.getText();
				String newAge = textField_2.getText();
				
				person.setPrenom(newPrenom);
				person.setNom(newNom);
				person.setAge(Integer.parseInt(newAge));
				
				dispose();
				
			}
		});
	}

}
