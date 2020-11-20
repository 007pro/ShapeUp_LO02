package fr.shapeUp.joueur;

import fr.shapeUp.partie.Carte;
import fr.shapeUp.partie.Partie;
import java.util.Scanner;

/**
 * La classe joueur physique va permettre a l'utilisateur de jouer une partie 
 * 
 * @author Adrien Warnet, Vincent Diop
 * @version 1.0
 *
 */
public class JoueurPhysique extends Joueur {
	
	Scanner saisiUseur = new Scanner(System.in);

	public JoueurPhysique(Partie partie,int numJoueur) {
		super(partie,numJoueur);
	}
	private boolean pose ;
	private boolean deplace;
	
	@Override
	public void jouerTour() {
		super.piocher();
		System.out.print("\n");
		do {
		System.out.println("Poser la carte sur quelle ligne ? "); //ligne et colonne sont inversé
		int  colonne = saisiUseur.nextInt();
		System.out.println("Quelle colonne ? ");
		int ligne= saisiUseur.nextInt();
		pose = super.poserCarte(ligne, colonne);
		}
		while(pose == false);
		System.out.print("\n");
		System.out.println("Déplacer une carte ? 1=oui/2=non ");
		
		int ouiOuNon = saisiUseur.nextInt();
		if(ouiOuNon == 1) {
			do {
			System.out.println("La carte est sur quelle ligne ? ");
			int colonneCarteADeplacer  = saisiUseur.nextInt();
			System.out.println("La carte est sur quelle colonne ? ");
			int ligneCarteADeplacer= saisiUseur.nextInt();
			System.out.println("Poser la carte sur quelle ligne ? ");
			int newColonne  = saisiUseur.nextInt();
			System.out.println("Quelle colonne ? ");
			int newLigne= saisiUseur.nextInt();
			deplace = super.deplacerCarte(ligneCarteADeplacer, colonneCarteADeplacer , newLigne , newColonne );
			}
			while(deplace == false);
		}
		else if (ouiOuNon == 2) {
			super.finTour();
		}
		super.finTour();
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
