package fr.shapeUp.partie;

import fr.shapeUp.partie.Deck;
import fr.shapeUp.partie.Carte.formeCarte;
import fr.shapeUp.partie.plateau.Plateau;
import fr.shapeUp.partie.plateau.Plateau.formePlateau;
import fr.shapeUp.joueur.Joueur;
import fr.shapeUp.joueur.JoueurPhysique;
import fr.shapeUp.joueur.JoueurVirutel;
import fr.shapeUp.partie.Carte;

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
	
	/**
	 * Constructeur de la classe
	 * @param forme la forme du plateau
	 */
	Partie(formePlateau forme){
		this.deck = new Deck();
		this.plateau = new Plateau(forme);
		this.numTour = 0;
	}
	
	/**
	 * Permet de lancer une partie, définie le nombre de joueur physique et joueur virtuel
	 * @param nbJoueurs nombre de joueurs physique
	 */
	public void lancerPartie(int nbJoueurs){
		this.joueurs = new Joueur[3]; 
		
		for(int i = 0 ; i < nbJoueurs; i++) {
			this.joueurs[i] = new JoueurPhysique(this,i);
			System.out.println("physique" + i);
		}
		for (int i = nbJoueurs;i<3;i++) {
			this.joueurs[i] = new JoueurVirutel(this,i);
			System.out.println("virtuel" + i);
		}
		while(this.numTour != 5) {
			nouveauTour();
			int i = 0;
			while(this.deck.getNombreDeCartes() != 0 && !this.plateau.rempli()) {
				System.out.println("Le joueur " + (i+1) +" joue son tour");
				this.joueurs[i].jouerTour();
				this.plateau.afficherPlateau();
				i = (i + 1) % 3;
			}
			this.plateau.accept(new Comptage(this));
		}
		System.out.println("Calcul des scores totaux");
		System.out.println("La partie se termine");
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
//	public static Partie partie = new Partie(3,1);
	// Exemple de partie ou les joueurs piochent et posent
	/*public static void main (String[] args){
		Partie partie = new Partie(3,1);
		partie.lancerPartie();
	}*/
}
