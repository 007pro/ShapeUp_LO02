package fr.shapeUp.partie;

import fr.shapeUp.partie.Deck;
import fr.shapeUp.joueur.Joueur;
import fr.shapeUp.joueur.JoueurPhysique;
import fr.shapeUp.partie.Carte;

public class Partie {
	
	public Deck deck;
	public Plateau plateau;
	private int numTour;
	
	Partie(int largeurP, int hauteurP){
		this.deck = new Deck();
		this.plateau = new Plateau(largeurP, hauteurP);
		this.numTour = 0;
	}
	
	public void lancerPartie(){
		Joueur joueur1 = new JoueurPhysique(this);
		while(this.numTour != 5) {
			nouveauTour();
			int i = 0;
			while(this.deck.getNombreDeCartes() != 0 && !this.plateau.rempli()) {
				System.out.println("Un joueur joue son tour");
				//this.plateau.placerCarte(i, 0, this.deck.piocher());
				joueur1.jouerTour();
				this.plateau.afficherPlateau();
				i++;
			}
		}
		System.out.println("La partie se termine");
	}
	
	private void nouveauTour(){
		this.numTour++;
		this.deck = new Deck();
		this.plateau.resetPlateau();
		//deck.piocher();
		System.out.println("Un nouveau tour est lanc�");
	}

//	public static Partie partie = new Partie(3,1);
	// Exemple de partie ou les joueurs piochent et posent
	public static void main (String[] args){
		Partie partie = new Partie(3,1);
		partie.lancerPartie();
	}
}
