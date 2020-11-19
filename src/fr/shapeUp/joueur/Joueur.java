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

	
	private Carte carteCourante; // la carte qu'il à dans la main et qu'il vas jouer
	
	
	
	
	public Joueur() {
		this.score = 0;
		this.carteVictoire = ;
		this.carteCourante = null;

	}
	

	public abstract void jouerTour();

	
	public void piocher() {

	//	this.carteCourante = carteCourante.randomCarte();

	}

	
	public void poserCarte(int position) {
		
		
	}


	public void deplacerCarte(Carte carteChoisie, int newPosition) {
		
	}

	
}
