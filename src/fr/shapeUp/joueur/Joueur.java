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
	protected Carte [] mainCourante = new Carte[3];
	private int typePartie;
	private Scanner saisiUseur = new Scanner(System.in);
	
	/**
	 * Constructeur de la classe
	 * @param partie la partie encore
	 * @param numJoueur le numéro du joueur
	 * @param typePartie determiner le type de partie
	 */
	public Joueur(Partie partie, int numJoueur, int typePartie) {
		this.score = 0;
		this.partie = partie;
		this.carteVictoire = partie.deck.piocher();
		this.carteCourante = null;
		this.typePartie = typePartie;
		

		System.out.print("\n");
		System.out.println("Le joueur" + (numJoueur + 1) + " viens d'être ajouté à la partie");
		System.out.print("Sa carte victoire est : ");
		this.carteVictoire.afficherCarte();
		System.out.print("\n");
		if (typePartie>=2) {
			piocherMain();
		}
	}

	/**
	 * Pour jouer un tour 
	 */
	public abstract void jouerTour();

	/**
	 * Pour jouer un tour avec les régles avancées
	 */
	public abstract void jouerTourAvancé();
	
	/**
	 * Pour jouer un tour avec les régles classiques
	 */
	public abstract void jouerTourClassique();
	
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
	 * Permet de constistuer la main du joueur pioche que 2 carte car il a déja la carte victoire qui est la première 
	 * et comme il ne pourra pas la jouer je ne la met pas dans l'objet maincourante
	 */
	public void piocherMain() {
		this.mainCourante = partie.deck.piocher(2);
		afficherMain(this.mainCourante);
	}
	
	/**
	 * Afficher un tableau de carte  
	 * @param main le tableau à afficher
	 */
	public void afficherMain(Carte[] main) {
		System.out.print("Carte victoire : ");
		this.carteVictoire.afficherCarte();
		System.out.println("");
		for(Carte elem: main)
		{
			elem.afficherCarte();
		}
		System.out.println("");
		
	}

	/**
	 * Pose la carte courante 
	 * @param position pose la carte à cette position
	 * @return
	 */
	public abstract boolean poserCarte(String position);
	
	/**
	 * Pose une carte et piocher une carte pour l'ajouter à la main du joueur
	 * @param position position de la carte à placer 
	 * @param numCarte choix de la carte dans la main 
	 * @return
	 */
	public abstract boolean poserCarteOfMain(String position,int numCarte);
	

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
	 * Modifier tourFini
	 * @param tourFini
	 */
	public void setTourFini(boolean tourFini) {
		this.tourFini = tourFini;
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
	
	/**
	 * @return mainCourante
	 */
	public Carte[] getMainCourante() {
		return mainCourante;
	}

	/**
	 * Modifier la mainCourante
	 * @param mainCourante
	 */
	public void setMainCourante(Carte[] mainCourante) {
		this.mainCourante = mainCourante;
	}
	
	/**
	 * 
	 * @return le type de partie
	 */
	public int getTypePartie() {
		return typePartie;
	}

}
