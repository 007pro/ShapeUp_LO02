package fr.shapeUp.Vue;

import fr.shapeUp.Vue.DialogChoixDesregles;
import fr.shapeUp.modele.joueur.Joueur;
import fr.shapeUp.modele.partie.Partie;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VuePartie extends JFrame {

	
	private JFrame fenetre;
	private JPanel panelJoueur;
	private ArrayList<Joueur> joueurs;
	//private ArrayList<VueJoueur> vueJoueurs = new ArrayList<>();
	private JLabel tas; 
	private JLabel pile;
	private JTextArea log;
	private JScrollPane scrollPane;
	
	
	/**
	 * Constructeur de la vue de la partie
	 * @param partie sur laquelle on vas influer
	 */
	public VuePartie(Partie partie) {
	
		 JButton boutonInit = new JButton("init");
		 JButton boutonPlacerCarte1carte = new JButton("Joueur avec 1 carte");
		 JButton boutonPlacerCarte2carte = new JButton("Joueur avec la main");
		 
		 this.setTitle("test des fenetres de dialog");
		    this.setSize(300, 100);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);      
		    this.getContentPane().setLayout(new FlowLayout());
		    this.getContentPane().add(boutonInit);
		    this.getContentPane().add(boutonPlacerCarte1carte);
		    this.getContentPane().add(boutonPlacerCarte2carte);
		    
		    boutonInit.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		        DialogChoixDesregles zd = new DialogChoixDesregles(null, "Coucou les ZérOs", true);
		        zd.setVisible(true);
		      }         
		    });
		   
		    
		    boutonPlacerCarte1carte.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent arg0) {
			    	 DialogJoue1Carte jv = new DialogJoue1Carte();
			    	 jv.setVisible(true);
			      }         
			    });
		    

		    boutonPlacerCarte2carte.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent arg0) {
			    	 DialogJoue2Cartes jv = new DialogJoue2Cartes();
			    	 jv.setVisible(true);
			      }         
			    });
		    
		    this.setVisible(true);      
		  }
				
	
	    
	
	
	
	public static void main(String[] args) {
		
		VuePartie window = new VuePartie(null);
		
		
	}

	
}
