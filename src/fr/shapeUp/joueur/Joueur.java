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

	protected int score = 0;
	protected Carte carteVictoire;
	private Partie partie;
	protected Carte carteCourante; // la carte qu'il à dans la main et qu'il vas jouer
	protected boolean carteEnMain = false;
	protected boolean tourFini;

	public Joueur(Partie partie, int numJoueur) {
		this.score = 0;
		this.partie = partie;
		this.carteVictoire = partie.deck.piocher();
		this.carteCourante = null;
		
		System.out.print("\n");
		System.out.println("Le joueur" + (numJoueur+1) + " viens d'être ajouté à la partie");
		System.out.print("Sa carte victoire est : ");
		this.carteVictoire.afficherCarte();
		System.out.print("\n");
	}

	public abstract void jouerTour();

	public void piocher() {
		tourFini = false;
		System.out.println("Carte Piochée");
		this.carteCourante = partie.deck.piocher();
		System.out.print("Votre carte est : ");
		this.carteCourante.afficherCarte();
		carteEnMain = true;

	}

	public boolean poserCarte(int ligne, int colonne) {
		boolean cartePlacé = partie.plateau.placerCarte(ligne-1, colonne-1, this.carteCourante);
		
		if (cartePlacé == true) { 
			System.out.println("Vous avez posé votre carte sur la ligne " + ligne +" et sur la colonne " + colonne);
			return true;
		}
		else if(cartePlacé == false) {
			System.out.println("il y a déja une carte ici");
			return false;
		}
		
			return false;
		
	} 

	public boolean deplacerCarte(int ligneCarteADeplacer, int colonneCarteADeplacer, int newLigne, int newColonne ) {
		System.out.println("vous allez déplacer une carte");
		Carte carteRetiré = partie.plateau.retirerCarte((ligneCarteADeplacer-1), (colonneCarteADeplacer-1));
		
		if (carteRetiré != null) {			
			boolean carteHere = poserCarte(newLigne, newColonne);
			if(carteHere ==false) {
				return false;
			}
			else {
				return true;
			}
		}
		else if (carteRetiré == null){
			System.out.println("il n'y a pas de carte ici");
			return false;
		}
	return false;
	}
	
	public void finTour() {
		carteCourante = null;
		carteEnMain = false;
		tourFini = true;
		System.out.println("Votre tour est terminé, au joueur suivant ! ");
		
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Carte getCarteVictoire() {
		return carteVictoire;
	}

	public Carte getCarteCourante() {
		return carteCourante;
	}

	public boolean isCarteEnMain() {
		return carteEnMain;
	}

	public boolean isTourFini() {
		return tourFini;
	}

}
