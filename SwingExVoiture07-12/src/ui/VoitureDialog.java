package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entity.BagnoleEntity;
import service.ServiceDAO;

public class VoitureDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textFieldMarque;
	private JTextField textFieldModele;
	private JTextField textFieldAnnee;
	private BagnoleEntity bEntity;
	private ServiceDAO dao = new ServiceDAO();
	private boolean isUpdate; //booolean pour différencier mode update/create

	/**
	 * Launch the application.
	 */
	// on supprime le main
	/**
	 * Create the application.
	 */
	public VoitureDialog(ServiceDAO dao) {
		this.dao = dao;
		isUpdate = false; //booolean pour différencier mode update/create
		initialize();
	}
	
	public VoitureDialog(BagnoleEntity bEntity, ServiceDAO dao) {
		this.bEntity = bEntity;
		this.dao = dao;
		isUpdate = true; //booolean pour différencier mode update/create
		initialize();
	}
	

	public BagnoleEntity getbEntity() {
		return bEntity;
	}



	public void setbEntity(BagnoleEntity bEntity) {
		this.bEntity = bEntity;
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	getContentPane().setLayout(null);
		
		JLabel lblMarque = new JLabel("Marque");
		lblMarque.setBounds(33, 48, 56, 20);
		getContentPane().add(lblMarque);

		
		JLabel lblModele = new JLabel("Modele");
		lblModele.setBounds(33, 93, 56, 20);
		getContentPane().add(lblModele);
		
		JLabel lblAnne = new JLabel("Annee");
		lblAnne.setBounds(33, 142, 56, 20);
		getContentPane().add(lblAnne);
		
		textFieldMarque = new JTextField();
		textFieldMarque.setBounds(119, 48, 120, 20);
		getContentPane().add(textFieldMarque);
		textFieldMarque.setColumns(10);
		
		textFieldModele = new JTextField();
		textFieldModele.setBounds(119, 93, 120, 20);
		getContentPane().add(textFieldModele);
		textFieldModele.setColumns(10);
		
		textFieldAnnee = new JTextField();
		textFieldAnnee.setBounds(119, 142, 120, 20);
		getContentPane().add(textFieldAnnee);
		textFieldAnnee.setColumns(10);
		
		if (bEntity != null) {
		textFieldMarque.setText(bEntity.getMarque());
		textFieldModele.setText(bEntity.getModele());
		textFieldAnnee.setText(String.valueOf(bEntity.getAnnee()));
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
				String newMarque = textFieldMarque.getText();
				String newModele = textFieldModele.getText();
				String newAnnee = textFieldAnnee.getText();
											
								
				if (isUpdate) { 						// si le boolean isUpdate == true => modification
					bEntity.setMarque(newMarque);
					bEntity.setModele(newModele);
					bEntity.setAnnee(Integer.parseInt(newAnnee));
				dao.update(bEntity);
				} else {								// si le boolean isUpdate == false => creation
					BagnoleEntity bEntity = new BagnoleEntity(0, newMarque, newModele, Integer.parseInt(newAnnee));
					dao.create(bEntity);
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
