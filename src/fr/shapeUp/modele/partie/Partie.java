package fr.shapeUp.modele.partie;

import fr.shapeUp.modele.joueur.Joueur;
import fr.shapeUp.modele.joueur.JoueurPhysique;
import fr.shapeUp.modele.joueur.JoueurVirutel;
import fr.shapeUp.modele.partie.Carte;
import fr.shapeUp.modele.partie.Deck;
import fr.shapeUp.modele.partie.Carte.formeCarte;
import fr.shapeUp.modele.partie.plateau.Plateau;
import fr.shapeUp.modele.partie.plateau.Plateau.formePlateau;

/**
 * Classe permet le bon déroulement d'une partie
 * @author Adrien Warnet, Vincent Diop
 *
 */
public class Partie {
	
	public Deck deck;
	public Plateau plateau;
	private int numTour;
	//private int nbJoueurs = 2;
	private Joueur[] joueurs;
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
		for (int i = 0; i<nbVirtu ; i++) {
			this.joueurs[i] = new JoueurVirutel(this,i,typePartie);
			System.out.println("virtuel" + i);
		}
//		while(this.numTour != 5) {
//			nouveauTour();
//			int i = 0;
//			while(this.deck.getNombreDeCartes() != 0 && !this.plateau.rempli()) {
//				System.out.println("Le joueur " + (i+1) +" joue son tour");
//				this.joueurs[i].jouerTour();
//				this.plateau.afficherPlateau();
//				i = (i + 1) % 3;
//			}
//			this.plateau.accept(new Comptage(this));
//		}
//		System.out.println("Calcul des scores totaux");
//		System.out.println("La partie se termine");
	}
	
	/**
	 * Démarrer un nouveau tour
	 */
	private void nouveauTour(){
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

//	public static Partie partie = new Partie(3,1);
	// Exemple de partie ou les joueurs piochent et posent
	/*public static void main (String[] args){
		Partie partie = new Partie(3,1);
		partie.lancerPartie();
	}*/
}
