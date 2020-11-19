package fr.shapeUp.joueur;

import java.util.Random;
import fr.shapeUp.partie.*;
import fr.shapeUp.partie.Partie.*;

/**
 * La classe joueur qui va être la classe d'origine des classes joueurVirtuel et
 * JoueurPhysique Elle est défini en classe abstraite car on n'est pas sensé
 * pouvoir l'instancier.
 * 
 * @author Adrien Warnet, Vincent Diop
 * @version 1.0
 * 
 */
public abstract class Joueur {

	private int score = 0;
	private Carte carteVictoire;
	private Partie partie;
	private Carte carteCourante; // la carte qu'il à dans la main et qu'il vas jouer
	private boolean carteEnMain = false;
	public boolean tourFini;

	public Joueur(Partie partie) {
		this.score = 0;
		this.partie = partie;
		this.carteVictoire = partie.deck.piocher();
		this.carteCourante = null;
		this.carteVictoire.afficherCarte();
		System.out.println("Un joueur viens d'être ajouté à la partie");
	}

	public abstract void jouerTour();

	public void piocher() {
		
		System.out.println("Carte Piochée");
		this.carteCourante = partie.deck.piocher();
		System.out.print("Votre carte est : ");
		this.carteCourante.afficherCarte();
		carteEnMain = true;

	}

	public void poserCarte(int ligne, int colonne) {
		boolean cartePlacé = partie.plateau.placerCarte(ligne, colonne, this.carteCourante);
		if (cartePlacé == true) { 
			System.out.println("Vous avez posé votre carte sur la ligne n°" + ligne +"et sur la colonne n°" + colonne);
		}
		else {
			System.out.println("il y a déja une carte ici");
		}
			
		
	} 

	public void deplacerCarte(int ligneCarteADeplacer, int colonneCarteADeplacer, int newLigne, int newColonne ) {
		System.out.println("vous allez déplacer une carte");
		Carte carteRetiré = partie.plateau.retirerCarte(ligneCarteADeplacer, colonneCarteADeplacer);
		
		if (carteRetiré != null) {
			poserCarte(newLigne, newColonne);
		}
		else {
			System.out.println("il n'y a pas de carte ici");
		}

	}
	
	public void finTour() {
		carteCourante = null;
		carteEnMain = false;
		tourFini = true;
		System.out.println("Votre tour est terminé, au joueur suivant ! ");
		
	}

}
