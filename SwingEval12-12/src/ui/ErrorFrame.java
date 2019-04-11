package ui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import entity.ErrorItem;
import service.ServiceDAO;
import ui.model.ModeleError;
import java.awt.Color;

public class ErrorFrame {

	private JFrame frame;
	private ServiceDAO dao = new ServiceDAO();
	private List<ErrorItem> eList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErrorFrame window = new ErrorFrame();
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
	public ErrorFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(32, 178, 170));
		
		
		
		frame.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent we) {
		    	ImageIcon icon = new ImageIcon("images/exit.gif"); //confirm dialog avec une image  
		    	UIManager.put("OptionPane.minimumSize", new Dimension(400, 150)); //modif la taille de JOptionPane
		    	
		        int result = JOptionPane.showConfirmDialog(frame, "Voulez-vous quitter ?", "Confirmation de fermeture de l'application : ", JOptionPane.YES_NO_OPTION,  JOptionPane.QUESTION_MESSAGE, icon);
		        if (result == JOptionPane.YES_OPTION) {
		          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        } else if (result == JOptionPane.NO_OPTION) {
		          frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		        }
		      }
		    });
		
		
		frame.setBounds(100, 100, 750, 550);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblLaListeDes = new JLabel("La liste des erreurs");
		lblLaListeDes.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 22));
		lblLaListeDes.setBounds(105, 56, 441, 33);
		frame.getContentPane().add(lblLaListeDes);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnSupprimer.setBounds(425, 213, 135, 33);
		frame.getContentPane().add(btnSupprimer);
		
		eList = dao.findAll();
		
		JList <ErrorItem> jlist = new JList <ErrorItem>();
		jlist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(jlist);
		jlist.setBounds(158, 108, 164, 256);
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // liste mono-selection
		jlist.setModel(new ModeleError(eList));

		
		JScrollPane jscrollPane = new JScrollPane(jlist);
		jscrollPane.setBounds(105, 107, 239, 234);
		frame.getContentPane().add(jscrollPane);
	
		
		
		
		btnSupprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jlist.getSelectedValue() == null) {
					return ;
				} else {
					ImageIcon icon = new ImageIcon("images/delete.gif");
				int response = JOptionPane.showConfirmDialog(null, "Etes-vous sur de vouloir détruire cet élément ?", "Suppression", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
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
