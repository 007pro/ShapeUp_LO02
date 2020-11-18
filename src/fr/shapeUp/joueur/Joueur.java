package fr.shapeUp.joueur;

import java.util.Random;

import fr.shapeUp.partie.*;

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

	/**
	 * score, vas représenter le score du joueur
	 */
	private int score = 0;

	/**
	 * représente la carte victoire du joueur
	 */
	private Carte carteVictoire;

	/**
	 * représente la carte que le joueur vas jouer chaque tour
	 */
	private Carte carteCourante; // la carte qu'il à dans la main et qu'il vas jouer

	/**
	 * construteur de Joueur, attribut au joueur sa carte victoire
	 */
	public Joueur() {
		this.score = 0;
		this.carteVictoire = carteVictoire.randomCarte();
		this.carteCourante = null;

	}

	/**
	 * Appelé quand le joueur va jouer son tour
	 */
	public abstract void jouerTour();

	/**
	 * Le joueur pioche une carte au hazard
	 */
	public void piocher() {

		this.carteCourante = carteCourante.randomCarte();

	}

	/**
	 * Le joueur pose la carte qu'il vient de piocher
	 * @param position l'endroit ou le joueur veut poser sa carte
	 */
	public void poserCarte(int position) {
		
		
	}

	/**
	 * Le joueur peut déplacer une carte qui est sur le plateau
	 * @param carteChoisie La carte qu'il veut déplacer
	 * @param newPosition La nouvelle position de la carte
	 */
	public void deplacerCarte(Carte carteChoisie, int newPosition) {
		
	}

	
}
