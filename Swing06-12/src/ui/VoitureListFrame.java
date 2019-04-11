package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

import ui.model.ModeleVoiture;
import ui.model.Voiture;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import java.awt.Color;


public class VoitureListFrame {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblListSelectionListener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VoitureListFrame window = new VoitureListFrame();
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
	public VoitureListFrame() {
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
		
		JButton btnNewButton = new JButton("Info");
		btnNewButton.setBounds(181, 59, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JList<Voiture> jlist = new JList<Voiture>();
		jlist.setBounds(21, 36, 150, 200);
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // liste mono-selection
		frame.getContentPane().add(jlist);
		
		List<Voiture>carList = new ArrayList<>();
		Voiture v1 = new Voiture ("207cc", "Peugeot");
		Voiture v2 = new Voiture ("x5", "BMW");
		Voiture v3 = new Voiture("Julia", "Alpha Romeo");
		Voiture v4 = new Voiture("Kuga", "Ford");
		
		carList.add(v1);
		carList.add(v2);
		carList.add(v3);
		carList.add(v4);
		
		ModeleVoiture modele = new ModeleVoiture(carList);
		jlist.setModel(modele);
		
		lblNewLabel = new JLabel("button text");
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setBounds(280, 59, 140, 23);
		frame.getContentPane().add(lblNewLabel);
		
		lblListSelectionListener = new JLabel("List Selection Listener text");
		lblListSelectionListener.setBounds(210, 161, 189, 30);
		frame.getContentPane().add(lblListSelectionListener);
		
		JLabel lblMousetext = new JLabel("mouseText");
		lblMousetext.setBounds(210, 210, 130, 26);
		frame.getContentPane().add(lblMousetext);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//int i = jlist.getSelectedIndex(); // recup index
				//Voiture v = jlist.getModel().getElementAt(i); // recup valeur par index => ces 2 lignes en comm = la ligne en dessous Voiture v = jlist.getSelectedValue();
				Voiture v = jlist.getSelectedValue();
				lblNewLabel.setText(v.getMarque());
			
			}
		});
		
		
		jlist.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				Voiture v = jlist.getSelectedValue();
				lblListSelectionListener.setText(v.getModele());
			}
		});
		
		jlist.addMouseListener(new MouseListener() { // text will appear in the lbl after a mouse dblclick
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2) {
					Voiture v = jlist.getSelectedValue();
					lblMousetext.setText(v.toString());
				}
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
