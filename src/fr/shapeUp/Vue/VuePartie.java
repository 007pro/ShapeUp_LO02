package fr.shapeUp.Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VuePartie {

	private JFrame frame;
	DialogChoixDesregles choixregle = new DialogChoixDesregles();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VuePartie window = new VuePartie();
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
	public VuePartie() {
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
		
		JButton btndemarrePartie = new JButton("D\u00E9marrer une partie");
		btndemarrePartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				choixregle.setVisible(true);
				btndemarrePartie.setVisible(false);
			}
		});
		btndemarrePartie.setBounds(165, 99, 129, 40);
		frame.getContentPane().add(btndemarrePartie);
	}
}
