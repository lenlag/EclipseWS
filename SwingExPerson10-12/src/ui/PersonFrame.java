package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import entity.PersonDTO;
import factory.Factory;
import service.IService;
import ui.model.ModelePerson;

public class PersonFrame {

	private JFrame frame;
	IService dao = Factory.getNewInstance().create(); // au lieu de ServiceDAOsql dao = new ServiceDAOsql(); car on a crée une Factory qui renvoie IService
	List<PersonDTO> pList;
	PersonDTO dto; 

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
	 *
	 */
	public PersonFrame() {
		try {
			initialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		WelcomePage wp = new WelcomePage();
		wp.setBounds(100, 100, 450, 300);
		wp.setModal(true);
		wp.setVisible(true);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList<PersonDTO> jlist = new JList <PersonDTO> ();
		jlist.setBounds(125, 74, 171, 206);
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // liste mono-selection
		frame.getContentPane().add(jlist);
		
		JLabel lblListe = new JLabel("La liste des personnes");
		lblListe.setBounds(125, 39, 140, 30);
		frame.getContentPane().add(lblListe);
		
		JButton btnCrer = new JButton("Creer");
		btnCrer.setBounds(369, 109, 100, 23);
		frame.getContentPane().add(btnCrer);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(369, 160, 100, 23);
		frame.getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(369, 214, 100, 23);
		frame.getContentPane().add(btnSupprimer);
		
		pList = dao.findAll();
		ModelePerson model = new ModelePerson(pList);
		jlist.setModel(model);
		
			
		btnCrer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				PersonDialog dialog = new PersonDialog(dao);
				dialog.setBounds(100, 100, 450, 300);
				dialog.setModal(true);
				dialog.setVisible(true);
				
			//	************************
				
				try {
					jlist.setModel(new ModelePerson(dao.findAll()));  // pour màj de la liste => au lieu de updateUI
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		btnModifier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jlist.getSelectedValue() == null) {
					return ;
				} else {
				
				String myId = jlist.getSelectedValue().getId();
				try {
					dto = dao.getById(myId);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PersonDialog dialog = new PersonDialog(dto, dao);
				dialog.setBounds(100, 100, 450, 300);
				dialog.setModal(true);
				dialog.setVisible(true);
				
				try {
					jlist.setModel(new ModelePerson(dao.findAll())); // pour màj de la liste => au lieu de updateUI
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
				}
				
			}
		});
		
		btnSupprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jlist.getSelectedValue() == null) {
					return ;
				} else {
				int response = JOptionPane.showConfirmDialog(null, "Etes-vous sur de vouloir détruire cet élément ?", "Suppression", JOptionPane.YES_NO_OPTION);
					if (response != JOptionPane.YES_OPTION) {
						return;
					}
				String myId = jlist.getSelectedValue().getId();
				try {
					dao.delete(myId);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				try {
					jlist.setModel(new ModelePerson(dao.findAll())); // pour màj de la liste => au lieu de updateUI
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		
	}
}
