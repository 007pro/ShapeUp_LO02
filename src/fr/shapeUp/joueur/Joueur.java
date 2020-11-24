package fr.shapeUp.joueur;

import java.util.Random;
import java.util.Scanner;

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
	protected Partie partie;
	protected Carte carteCourante; // la carte qu'il à dans la main et qu'il vas jouer
	protected boolean carteEnMain = false;
	protected boolean tourFini;
	private String position;
	Scanner saisiUseur = new Scanner(System.in);

	public Joueur(Partie partie, int numJoueur) {
		this.score = 0;
		this.partie = partie;
		this.carteVictoire = partie.deck.piocher();
		this.carteCourante = null;

		System.out.print("\n");
		System.out.println("Le joueur" + (numJoueur + 1) + " viens d'être ajouté à la partie");
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

	
	public abstract boolean poserCarte(String position);

	public void deplacerCarte() {

		System.out.println("vous allez déplacer une carte");
		Carte carteRetiré;
		boolean carteHere;
		do {
			System.out.println("La carte est à quelle position ? ");
			String positionCarteADeplacer = saisiUseur.nextLine();
			carteRetiré = partie.plateau.retirerCarte(positionCarteADeplacer);
			if (carteRetiré == null) {
				System.out.println("il n'y a pas de carte ici");
			}
		} while (carteRetiré == null);

		do {
			System.out.println("Poser la carte à quelle position ? ");
			String newPosition = saisiUseur.nextLine();
			carteHere = poserCarte(newPosition);
		} while (carteHere == false);

		/*
		 * if (carteRetiré != null) { boolean carteHere = poserCarte(nouvellePosition);
		 * if(carteHere ==false) { return false; } else { return true; } } else if
		 * (carteRetiré == null){ System.out.println("il n'y a pas de carte ici");
		 * return false; } return false;
		 */
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
