package fr.shapeUp.joueur;

import java.util.Random;
import java.util.Scanner;

import fr.shapeUp.partie.*;
import fr.shapeUp.partie.Partie.*;

/**
 * La classe joueur qui va �tre la classe d'origine des classes joueurVirtuel et
 * JoueurPhysique Elle est d�fini en classe abstraite car on n'est pas sens�
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
	protected Carte carteCourante; // la carte qu'il � dans la main et qu'il vas jouer
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
		System.out.println("Le joueur" + (numJoueur + 1) + " viens d'�tre ajout� � la partie");
		System.out.print("Sa carte victoire est : ");
		this.carteVictoire.afficherCarte();
		System.out.print("\n");
	}

	public abstract void jouerTour();

	public void piocher() {
		tourFini = false;
		System.out.println("Carte Pioch�e");
		this.carteCourante = partie.deck.piocher();
		System.out.print("Votre carte est : ");
		this.carteCourante.afficherCarte();
		carteEnMain = true;

	}

	
	public abstract boolean poserCarte(String position);

	public void deplacerCarte() {

		System.out.println("vous allez d�placer une carte");
		Carte carteRetir�;
		boolean carteHere;
		do {
			System.out.println("La carte est � quelle position ? ");
			String positionCarteADeplacer = saisiUseur.nextLine();
			carteRetir� = partie.plateau.retirerCarte(positionCarteADeplacer);
			if (carteRetir� == null) {
				System.out.println("il n'y a pas de carte ici");
			}
		} while (carteRetir� == null);

		do {
			System.out.println("Poser la carte � quelle position ? ");
			String newPosition = saisiUseur.nextLine();
			carteHere = poserCarte(newPosition);
		} while (carteHere == false);

		/*
		 * if (carteRetir� != null) { boolean carteHere = poserCarte(nouvellePosition);
		 * if(carteHere ==false) { return false; } else { return true; } } else if
		 * (carteRetir� == null){ System.out.println("il n'y a pas de carte ici");
		 * return false; } return false;
		 */
	}

	public void finTour() {
		carteCourante = null;
		carteEnMain = false;
		tourFini = true;
		System.out.println("Votre tour est termin�, au joueur suivant ! ");

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
