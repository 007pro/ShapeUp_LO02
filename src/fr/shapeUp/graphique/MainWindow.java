package fr.shapeUp.graphique;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	public MainWindow() {
		// TODO Auto-generated constructor stub
		this.setTitle("Shape Up");
		this.setSize(1000,600);
		this.setLocationRelativeTo(null); //faire apparaitre au centre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	

}
