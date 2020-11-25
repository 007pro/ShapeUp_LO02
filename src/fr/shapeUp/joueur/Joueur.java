package fr.shapeUp.joueur;

import java.util.Random;
import java.util.Scanner;

import fr.shapeUp.partie.*;
import fr.shapeUp.partie.Partie.*;

/**
 * Classe mère de JoueurPhysique et JoueurVirutel, elle est abstraite pour qu'on ne puisse pas l'instancier.
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

	/**
	 * Constructeur de la classe
	 * @param partie la partie encore
	 * @param numJoueur le numéro du joueur
	 */
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

	/**
	 * Pour jouer un tour
	 */
	public abstract void jouerTour();

	/**
	 * Pour piocher une carte dans le deck
	 */
	public void piocher() {
		tourFini = false;
		System.out.println("Carte Piochée");
		this.carteCourante = partie.deck.piocher();
		System.out.print("Votre carte est : ");
		this.carteCourante.afficherCarte();
		carteEnMain = true;

	}

	/**
	 * Pose la carte courante 
	 * @param position pose la carte à cette position
	 * @return
	 */
	public abstract boolean poserCarte(String position);

	/**
	 * Déplace une carte
	 */
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

	}

	/**
	 * Cloture le tour d'un joueur
	 */
	public void finTour() {
		carteCourante = null;
		carteEnMain = false;
		tourFini = true;
		System.out.println("Votre tour est terminé, au joueur suivant ! ");

	}

	/**
	 * @return score
	 */
	public int getScore() {
		return score;
	}

	
	/**
	 * Modifier score
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return carteVictoire
	 */
	public Carte getCarteVictoire() {
		return carteVictoire;
	}

	/**
	 * @return carteCourante
	 */
	public Carte getCarteCourante() {
		return carteCourante;
	}

	/**
	 * @return carteEnMain
	 */
	public boolean isCarteEnMain() {
		return carteEnMain;
	}

	/**
	 * @return tourFini
	 */
	public boolean isTourFini() {
		return tourFini;
	}

	/**
	 * @return position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * Modifier position
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position;
	}

}
