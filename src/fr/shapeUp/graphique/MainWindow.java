package fr.shapeUp.graphique;

import fr.shapeUp.graphique.WindowInit;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainWindow extends JFrame {

	public MainWindow() {
	
		JButton bouton = new JButton("Démarrer une partie");
		// TODO Auto-generated constructor stub
		this.setTitle("Shape Up");
		this.setSize(1000,600);
		this.setLocationRelativeTo(null); //faire apparaitre au centre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.getContentPane().setLayout(new FlowLayout());
	    this.getContentPane().add(bouton);
	    bouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {
	        WindowInit choixPartie = new WindowInit(null, "Choix des régles", true);
	        if(choixPartie.isPartieDemarre()) {
	        	bouton.setVisible(false);
	        }
	      }
	    });
	    this.setVisible(true);
	    
	    
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainWindow mainwin= new MainWindow();
		//WindowInit win = WindowInit(null, "choix",true);
		
	}

	
}
