package fr.shapeUp.Vue;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import fr.shapeUp.controleur.ControleurTest;
import fr.shapeUp.modele.joueur.Joueur;
import fr.shapeUp.modele.partie.Carte;
import fr.shapeUp.modele.partie.Partie;
import fr.shapeUp.modele.partie.plateau.Plateau;

/**
 * Vue du texte 
 * @author Adrien Warnet, Vincent Diop
 *
 */
public class VueTexte implements Observer, Runnable{
	public static String QUITTER = "Quit";
    public static String POSER = "P";
    public static String DEPLACER = "D";
    public static String NTOUR = "N";
    public static String PROMPT = ">";

    /**
     * Variable partie 
     */
    private Partie partie;
    /**
     * Controleur de la partie
     */
    private ControleurTest controleur;
    /**
     * La vue de la partie
     */
    private DialogPartie vuePartie;

    /**
     * Vue du texte 
     * @param partie
     * @param controleur
     * @param vuePartie
     */
    public VueTexte(Partie partie, ControleurTest controleur, DialogPartie vuePartie) {
		this.partie = partie;
		this.controleur = controleur;
		this.vuePartie = vuePartie;
		this.partie.getPlateau().addObserver(this);
		for(Joueur joueur : this.partie.getJoueurs()) {
			joueur.addObserver(this);
		}
		Thread t = new Thread(this);
		t.start();
    }

    /**
     * Lancement de la vue texte
     */
    public void run() {

	String saisie = null;
	boolean quitter = false;

	System.out.println("Taper " + VueTexte.POSER + " pour poser une carte ; " + VueTexte.DEPLACER + " pour deplacer une carte ; " + VueTexte.POSER + " pour le tour suivant ; " + VueTexte.QUITTER + " pour quitter.");

	do {
	    saisie = this.lireChaine();

	    if (saisie != null) {
		if (saisie.equals(VueTexte.POSER) == true) {
			boolean pose;
			do {
			System.out.print("Entrer coordonnée >");
			saisie = this.lireChaine();
			pose = partie.getJoueurs()[controleur.getCurrentPlayer()].poserCarte(saisie);
		    } while (!pose);
			this.vuePartie.getBtnNextTurn().setEnabled(true);
			this.vuePartie.getBtnPlacer().setEnabled(false);
		} else if (saisie.equals(VueTexte.NTOUR) == true) {
			this.vuePartie.getBtnNextTurn().doClick();   
		} else if (saisie.equals(VueTexte.DEPLACER) == true) {
			Carte carteRetiree;
			boolean pose;
			do {
				System.out.print("Entrer coordonnée pour retirer >");
				saisie = this.lireChaine();
				carteRetiree = partie.getPlateau().retirerCarte(saisie);
			}while (carteRetiree == null);
			do {
				System.out.print("Entrer coordonnée pour poser >");
				saisie = this.lireChaine();
				pose = partie.getPlateau().placerCarte(saisie, carteRetiree);
			}while(!pose);
			this.vuePartie.getBtnDeplace().setEnabled(false);
		} else if (saisie.equals(VueTexte.QUITTER) == true) {
		    quitter = true;		    
		} else {
		    System.out.println("Commande non reconnue...");
		}		
	    }
	} while (quitter == false);
	System.exit(0);
    }

    private String lireChaine() {
	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	String resultat = null;
	try {
	    System.out.print(VueTexte.PROMPT);
	    resultat = br.readLine();
	} catch (IOException e) {
	    System.err.println(e.getMessage());
	}
	return resultat;	
    }

    @Override
    public void update(Observable arg0, Object arg1) {
    	if(arg0 instanceof Plateau) {
    		this.partie.getPlateau().afficherPlateau();
    		System.out.print(VueTexte.PROMPT);
    	}
    	if(arg0 instanceof Joueur) {
			System.out.println("Vous piochez une carte : " + ((Joueur)arg0).getCarteCourante());
			System.out.print(VueTexte.PROMPT);
		}
    }
}

