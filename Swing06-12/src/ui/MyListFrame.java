package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;

import ui.model.MyModel;
import javax.swing.JTextArea;

public class MyListFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyListFrame window = new MyListFrame();
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
	public MyListFrame() {
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
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(292, 87, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JList<String> jlist = new JList<String>();
		jlist.setBounds(21, 36, 100, 150);
		frame.getContentPane().add(jlist);
		
		List<String>carList = new ArrayList<>();
		carList.add("Lamborgini");
		carList.add("Ferrari");
		carList.add("Maseratti");
		carList.add("Alfa Romeo");
		
		MyModel model = new MyModel(carList);
		jlist.setModel(model);
		
		JTextArea txtrEnterANew = new JTextArea();
		txtrEnterANew.setBounds(269, 36, 134, 33);
		frame.getContentPane().add(txtrEnterANew);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { // to add new items to JList by clicking on a button
				String s  = txtrEnterANew.getText();
				carList.add(s);
				jlist.updateUI();
			}
		});
		
		
		
	}
}
