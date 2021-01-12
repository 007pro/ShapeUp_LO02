package fr.utt.lo02.shapeUp.modele.joueur;

import java.util.Observable;
import java.util.Random;
import java.util.Scanner;

import fr.utt.lo02.shapeUp.modele.partie.*;
import fr.utt.lo02.shapeUp.modele.partie.Partie.*;

/**
 * Classe m�re de JoueurPhysique et JoueurVirutel, elle est abstraite pour qu'on ne puisse pas l'instancier.
 * 
 * @author Adrien Warnet, Vincent Diop
 * @version 1.0
 * 
 */
public abstract class Joueur extends Observable {

	/**
	 * Score de la partie 
	 */
	protected int score = 0;
	/**
	 * La carte victoire du joueur
	 */
	protected Carte carteVictoire;
	/**
	 * La partie 
	 */
	protected Partie partie;
	/**
	 * La carte que le joueur � dans la main, regle classique
	 */
	protected Carte carteCourante; 
	/**
	 * Etat de la main du joueur
	 */
	protected boolean carteEnMain = false;
	/**
	 * Etat du tour
	 */
	protected boolean tourFini;
	/**
	 * Position de pose de la carte
	 */
	private String position;
	/**
	 * Main du joueur, regle avanc�e
	 */
	protected Carte [] mainCourante = new Carte[3];
	/**
	 * Le type de partie
	 */
	private int typePartie;
	/**
	 * Saisi utilisateur
	 */
	private Scanner saisiUseur = new Scanner(System.in);
	
	/**
	 * Constructeur de la classe
	 * @param partie la partie encore
	 * @param numJoueur le num�ro du joueur
	 * @param typePartie determiner le type de partie
	 */
	public Joueur(Partie partie, int numJoueur, int typePartie) {
		this.score = 0;
		this.partie = partie;
		this.carteVictoire = partie.getDeck().piocher();
		this.carteCourante = null;
		this.typePartie = typePartie;
		

		System.out.print("\n");
		System.out.println("Le joueur" + (numJoueur + 1) + " viens d'�tre ajout� � la partie");
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
	 * Pour jouer un tour avec les r�gles avanc�es
	 */
	public abstract void jouerTourAvanc�();
	
	/**
	 * Pour jouer un tour avec les r�gles classiques
	 */
	public abstract void jouerTourClassique();
	
	/**
	 * Pour piocher une carte dans le deck
	 */
	public void piocher() {
		tourFini = false;
		this.carteCourante = partie.getDeck().piocher();
		carteEnMain = true;
		this.setChanged();
		this.notifyObservers(this.carteCourante);
	}
	
	/**
	 * Permet de constistuer la main du joueur pioche que 2 cartes car il a d�ja la carte victoire qui est la premi�re 
	 * et comme il ne pourra pas la jouer je ne la met pas dans l'objet maincourante
	 */
	public void piocherMain() {
		this.mainCourante = partie.getDeck().piocher(2);
		afficherMain(this.mainCourante);
	}
	
	/**
	 * Afficher un tableau de carte  
	 * @param main le tableau � afficher
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
	 * @param position pose la carte � cette position
	 * @return
	 */
	public abstract boolean poserCarte(String position);
	
	/**
	 * Pose une carte et piocher une carte pour l'ajouter � la main du joueur
	 * @param position position de la carte � placer 
	 * @param numCarte choix de la carte dans la main 
	 * @return
	 */
	public abstract boolean poserCarteOfMain(String position,int numCarte);
	

	/**
	 * D�place une carte
	 */
	public abstract void deplacerCarte() ;

	/**
	 * Cloture le tour d'un joueur
	 */
	public void finTour() {
		carteCourante = null;
		carteEnMain = false;
		tourFini = true;

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
