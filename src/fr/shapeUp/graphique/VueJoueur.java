package fr.shapeUp.graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.shapeUp.joueur.Joueur;
import fr.shapeUp.joueur.JoueurPhysique;
import fr.shapeUp.partie.Carte;
import fr.shapeUp.partie.Partie;
import fr.shapeUp.partie.plateau.Plateau;
import fr.shapeUp.partie.plateau.Plateau.formePlateau;

public class VueJoueur extends JDialog {
	

	private Joueur joueur; 
	private JPanel main;
	private LinkedList<VueCarte> carteGraphique = new LinkedList<>();
	private JTextField position;
	private Carte carteMain;
	private ArrayList<Carte> cartes;
	private JLabel positionLabel,choixDeLaCarteLabel;
	private JComboBox choixDeLaCarte;
	
	public VueJoueur(Joueur joueur,JFrame parent,String title,boolean modal) {
		super(parent, title, modal);
		this.joueur = joueur;
		this.cartes = new ArrayList<>();
		this.setSize(550, 230);
		//this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		//this.initOneCard();
		this.initTwocard();
		
		
	}
	
	/**
	 * Initialise les composants de la fenêtre
	 */
	public void initOneCard() {
		
		JLabel image = new JLabel(new ImageIcon("img/CarreBleueVide.jpg"));
		/*JLabel main = new JLabel();
		VueCarte vuecarte = new VueCarte(joueur.getCarteCourante());
		main = vuecarte.getImage();*/
		
	    JPanel panPosition = new JPanel();
	    panPosition.setBackground(Color.white);
	    panPosition.setPreferredSize(new Dimension(220, 60));
	    position = new JTextField();
	    position.setPreferredSize(new Dimension(100, 25));
	    panPosition.setBorder(BorderFactory.createTitledBorder("Position de pose"));
	    positionLabel = new JLabel("Saisir un nom :");
	    panPosition.add(positionLabel);
	    panPosition.add(position);
	    
	 
		
	    JPanel control = new JPanel();
	    control.setLayout(new FlowLayout());
	    final JButton okBouton = new JButton("Ok");
	    
	    JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(image);
		content.add(panPosition);
	   
	    control.add(okBouton);
	    


		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);
	    this.pack();
		
	}
	
	public void initTwocard() {
		
		JLabel image = new JLabel(new ImageIcon("img/CarreBleueVide.jpg"));
		JLabel image2 = new JLabel(new ImageIcon("img/CarreBleueVide.jpg"));
		/*JLabel main = new JLabel();
		VueCarte vuecarte = new VueCarte(joueur.getCarteCourante());
		main = vuecarte.getImage();*/
		
	    JPanel panPosition = new JPanel();
	    panPosition.setBackground(Color.white);
	    panPosition.setPreferredSize(new Dimension(220, 60));
	    position = new JTextField();
	    position.setPreferredSize(new Dimension(100, 25));
	    panPosition.setBorder(BorderFactory.createTitledBorder("Position de pose"));
	    positionLabel = new JLabel("Saisir un nom :");
	    panPosition.add(positionLabel);
	    panPosition.add(position);
		
	 // le nombre de joueurs
 		JPanel panChoixCarte = new JPanel();
 		panChoixCarte.setBackground(Color.white);
 		panChoixCarte.setPreferredSize(new Dimension(220, 60));
 		panChoixCarte.setBorder(BorderFactory.createTitledBorder("Nombre de joueurs"));
 		choixDeLaCarte = new JComboBox();
 		choixDeLaCarte.addItem("1");
 		choixDeLaCarte.addItem("2");
 		choixDeLaCarteLabel = new JLabel(" Joueurs");
 		panChoixCarte.add(choixDeLaCarte); 
 		panChoixCarte.add(choixDeLaCarteLabel);
	    
	    JPanel control = new JPanel();
	    control.setLayout(new FlowLayout());
	    final JButton okBouton = new JButton("Ok");
	    
	    
	    JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(image);
		content.add(image2);
		content.add(panPosition);
		content.add(panChoixCarte);
	   
	    control.add(okBouton);
	      
		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);
	    this.pack();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WindowInit choixPartie = new WindowInit(null, "Choix des régles", true);
		//VuePartie window = new VuePartie(null);
		VueJoueur J = new VueJoueur(null, null, "teste", false);
		
		
				
		
		
	}

}
