package fr.utt.lo02.shapeUp.modele.partie;

import fr.utt.lo02.shapeUp.modele.joueur.Joueur;
import fr.utt.lo02.shapeUp.modele.joueur.JoueurPhysique;
import fr.utt.lo02.shapeUp.modele.joueur.JoueurVirutel;
import fr.utt.lo02.shapeUp.modele.partie.Carte;
import fr.utt.lo02.shapeUp.modele.partie.Deck;
import fr.utt.lo02.shapeUp.modele.partie.Carte.formeCarte;
import fr.utt.lo02.shapeUp.modele.partie.plateau.Plateau;
import fr.utt.lo02.shapeUp.modele.partie.plateau.Plateau.formePlateau;

/**
 * Classe permet le bon déroulement d'une partie
 * @author Adrien Warnet, Vincent Diop
 *
 */
public class Partie {
	
	
	/**
	 * Variable deck de la partie
	 */
	private Deck deck;
	/**
	 * Variable plateau de la partie
	 */
	private Plateau plateau;
	/**
	 * Variable numéro de tour de la partie
	 */
	private int numTour;
	/**
	 * Tableau des joueurs
	 */
	private Joueur[] joueurs;
	/**
	 * Variable type de partie 
	 */
	private int typePartie ;
	
	/**
	 * Constructeur de la classe
	 * @param forme la forme du plateau
	 */
	public Partie(formePlateau forme){
		this.deck = new Deck();
		this.plateau = new Plateau(forme);
		this.numTour = 0;
	}
	
	/**
	 * Permet de lancer une partie, définie le nombre de joueur physique et joueur virtuel
	 * @param nbJoueurs nombre de joueurs physique
	 * @param typePartie en fonction des règles
	 */
	public void lancerPartie(int nbJoueurs,int nbVirtu,int typePartie){
		this.typePartie = typePartie;
		this.joueurs = new Joueur[nbJoueurs + nbVirtu]; 
		
		for(int i = 0 ; i < nbJoueurs; i++) {
			this.joueurs[i] = new JoueurPhysique(this,i,typePartie);
			System.out.println("physique" + i);
		}
		for (int i = nbJoueurs; i < nbJoueurs + nbVirtu ; i++) {
			this.joueurs[i] = new JoueurVirutel(this,i,typePartie);
			System.out.println("virtuel" + i);
		}

	}
	
	/**
	 * @return Le paquet de la partie
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * @return le plateau de la partie
	 */
	public Plateau getPlateau() {
		return plateau;
	}

	/**
	 * @return le numéro de tour
	 */
	public int getNumTour() {
		return numTour;
	}

	/**
	 * Démarrer un nouveau tour
	 */
	public void nouveauTour(){
		this.numTour++;
		this.deck = new Deck();
		this.plateau.resetPlateau();
		//deck.piocher();
		System.out.println("Un nouveau tour est lancé");
	}

	/**
	 * @return les Joueurs
	 */
	public Joueur[] getJoueurs() {
		return this.joueurs;
	}
	
    /**
     * @return le type de partie
     */
	public int getTypePartie() {
		return typePartie;
	}

}
