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

import entity.BagnoleEntity;
import service.ServiceDAO;
import ui.model.ModeleVoiture;

public class VoitureFrame {

	private JFrame frame;
	private ServiceDAO dao = new ServiceDAO();
	private List<BagnoleEntity> vList;
	private BagnoleEntity bEntity; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VoitureFrame window = new VoitureFrame();
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
	public VoitureFrame() {
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
		
		JList<BagnoleEntity> jlist = new JList <BagnoleEntity> ();
		jlist.setBounds(125, 74, 171, 206);
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // liste mono-selection
		frame.getContentPane().add(jlist);
		
		JLabel lblLaListeDes = new JLabel("La liste des voitures");
		lblLaListeDes.setBounds(125, 39, 140, 30);
		frame.getContentPane().add(lblLaListeDes);
		
		JButton btnCrer = new JButton("Creer");
		btnCrer.setBounds(369, 109, 100, 23);
		frame.getContentPane().add(btnCrer);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(369, 160, 100, 23);
		frame.getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(369, 214, 100, 23);
		frame.getContentPane().add(btnSupprimer);
		
		vList = dao.findAll();
		ModeleVoiture model = new ModeleVoiture(vList);
		jlist.setModel(model);
		
			
		btnCrer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VoitureDialog dialog = new VoitureDialog(dao);
				dialog.setBounds(100, 100, 450, 300);
				dialog.setModal(true);
				dialog.setVisible(true);
				
			//	************************
				
				jlist.updateUI();
				
			}
		});
		
		
		btnModifier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jlist.getSelectedValue() == null) {
					return ;
				} else {
				
				long id = jlist.getSelectedValue().getId();
				bEntity = dao.getById(id);
				VoitureDialog dialog = new VoitureDialog(bEntity, dao);
				dialog.setBounds(100, 100, 450, 300);
				dialog.setModal(true);
				dialog.setVisible(true);
				
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
				long id = jlist.getSelectedValue().getId();
				try {
					dao.delete(id);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				jlist.updateUI();
				}
			}
		});
		
	}
}
