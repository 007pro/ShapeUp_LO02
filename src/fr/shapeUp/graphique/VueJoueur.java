package fr.shapeUp.graphique;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.shapeUp.joueur.Joueur;
import fr.shapeUp.partie.Carte;
import fr.shapeUp.partie.Partie;

public class VueJoueur extends JDialog {
	

	private Partie partie; 
	private JPanel main;
	private LinkedList<VueCarte> carteGraphique = new LinkedList<>();
	private JLabel nom;
	private Carte carteMain;
	private ArrayList<Carte> cartes;
	
	public VueJoueur(Partie partie,JFrame parent,String title,boolean modal) {
		super(parent, title, modal);
		this.partie = partie;
		this.cartes = new ArrayList<>();
		this.setSize(550, 230);
		//this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		this.initComponent();
		
		
	}
	
	/**
	 * Initialise les composants de la fenêtre
	 */
	public void initComponent() {
		JPanel fenetre = new JPanel();
		
		
		JPanel main = new JPanel();
		
		main = vuecarte(partie.j);
			    
	    JPanel control = new JPanel();
	    control.setLayout(new FlowLayout());
	    final JButton okBouton = new JButton("Ok");
	    
	    
	   
	    control.add(okBouton);
	    fenetre.add(main);
	    fenetre.add(control);
	   
	    this.getContentPane().add(fenetre, BorderLayout.SOUTH);
	    this.pack();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WindowInit choixPartie = new WindowInit(null, "Choix des régles", true);
		//VuePartie window = new VuePartie(null);
	
		VueJoueur j = new VueJoueur(null, null, "test", true);
		
	}

}
