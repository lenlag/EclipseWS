package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entity.PersonDTO;
import persistence.exception.DaoException;
import service.IService;

public class PersonDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textFieldPrenom;
	private JTextField textFieldNom;
	private JTextField textFieldAge;
	private IService dao = null; //au lieu de ServiceDAOsql dao = new ServiceDAOsql(); car on a crée une Factory qui renvoie IService
	private boolean isUpdate; //booolean pour différencier mode update/create
	private PersonDTO dto;

	/**
	 * Launch the application.
	 */
	// on supprime le main
	/**
	 * Create the application.
	 */
	public PersonDialog(IService dao) { //IService en param au lieu de ServiceDAOsql
		this.dao = dao;
		isUpdate = false; //booolean pour différencier mode update/create
		initialize();
	}
	
	public PersonDialog(PersonDTO dto, IService dao) { //idem
		this.dto = dto;
		this.dao = dao;
		isUpdate = true; //booolean pour différencier mode update/create
		initialize();
	}
	



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	getContentPane().setLayout(null);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(33, 48, 56, 20);
		getContentPane().add(lblPrenom);

		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(33, 93, 56, 20);
		getContentPane().add(lblNom);
		
		JLabel lblAnne = new JLabel("Age");
		lblAnne.setBounds(33, 142, 56, 20);
		getContentPane().add(lblAnne);
		
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(119, 48, 120, 20);
		getContentPane().add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(119, 93, 120, 20);
		getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldAge = new JTextField();
		textFieldAge.setBounds(119, 142, 120, 20);
		getContentPane().add(textFieldAge);
		textFieldAge.setColumns(10);
		
		if (dto != null) {
			textFieldPrenom.setText(dto.getFirstName());
			textFieldNom.setText(dto.getLastName());
			textFieldAge.setText(String.valueOf(dto.getAge()));
		}
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(62, 216, 89, 23);
		getContentPane().add(btnOk);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(247, 216, 89, 23);
		getContentPane().add(btnAnnuler);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String newPrenom = textFieldPrenom.getText();
				String newNom = textFieldNom.getText();
				String newAge = textFieldAge.getText();
											
								
				if (isUpdate) { 						// si le boolean isUpdate == true => modification
					dto.setFirstName(newPrenom);
					dto.setLastName(newNom);
					dto.setAge(Integer.parseInt(newAge));
					try {
						dao.update(dto);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {								// si le boolean isUpdate == false => creation
					PersonDTO dto = new PersonDTO (0+"", newPrenom, newNom, Integer.parseInt(newAge)); //0+"" = pour passer en param String qui sera transformé en int, id est en auto-incrementation
					try {
						dao.create(dto);
					} catch (DaoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
				dispose();
				
			}
		});
		
		
		
		
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		
	}
	
}
