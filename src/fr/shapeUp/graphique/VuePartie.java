package fr.shapeUp.graphique;

import fr.shapeUp.graphique.WindowInit;
import fr.shapeUp.joueur.Joueur;
import fr.shapeUp.partie.Partie;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VuePartie {

	
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
	
				//Création de la fenêtre
				fenetre = new JFrame("Bataille Norvégienne");
				fenetre.setLayout(new BorderLayout());
				fenetre.setResizable(true);
				
				//Panel qui contient les joueurs
				panelJoueur = new JPanel();
				panelJoueur.setLayout(new BoxLayout(panelJoueur, BoxLayout.Y_AXIS));
				//On lui ajoute un JScrollPane (car si + de 5 joueurs, ça dépasse)
				JScrollPane scroll = new JScrollPane();
				scroll.setViewportView(panelJoueur);
				
				
				//Image d'un tapis
				JPanel panelTapis = new JPanel();
				JLabel imgTapis = new JLabel(new ImageIcon("img/shape.jpg"));
			
				
				tas = new JLabel(new ImageIcon("img/tasvide.png"));
				pile = new JLabel(new ImageIcon("img/b2fv.png")); 
				
				imgTapis.setLayout(new GridLayout()); 
				imgTapis.add(tas);
				imgTapis.add(pile);
				panelTapis.add(imgTapis);
				
				
				
				/*// Pour tous les joueurs on ajoute leur vue respective
				Iterator<Joueur> it = joueurs.iterator();
				while (it.hasNext()){
					VueJoueur vueJoueur = new VueJoueur(it.next());
					vueJoueurs.add(vueJoueur);
					panelJoueur.add(vueJoueur.getJpanel());
					
				}*/
				
				/*TextArea des logs
				setLog(new JTextArea());
				getLog().setEditable(false);
				getLog().setRows(5);
				scrollPane = new JScrollPane(getLog());*/
				
				JButton continuer = new JButton("continuer");
				// Permet de jouer au fur et à mesure
				continuer.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent me) {
						
					}
				});
				
				
				fenetre.add(scrollPane, BorderLayout.NORTH);
				fenetre.add(scroll, BorderLayout.WEST);
				fenetre.add(continuer, BorderLayout.SOUTH);
				fenetre.add(panelTapis, BorderLayout.EAST);
				
				
				
				
				fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				fenetre.pack();
				fenetre.setVisible(true);
				fenetre.setLocationRelativeTo(null);;
				
				
				
	
	    
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WindowInit choixPartie = new WindowInit(null, "Choix des régles", true);
		VuePartie window = new VuePartie(null);
		//WindowInit win = WindowInit(null, "choix",true);
		
	}

	
}
