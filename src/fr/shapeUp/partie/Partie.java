package fr.shapeUp.partie;

import fr.shapeUp.partie.Deck;
import fr.shapeUp.partie.Carte;

public class Partie {
	
	private Deck deck;
	private Plateau plateau;
	private int numTour;
	
	Partie(int largeurP, int hauteurP){
		this.deck = new Deck();
		this.plateau = new Plateau(largeurP, hauteurP);
		this.numTour = 0;
	}
	
	public void lancerPartie(){
		while(this.numTour != 5) {
			nouveauTour();
			int i = 0;
			while(this.deck.getNombreDeCartes() != 0 && !this.plateau.rempli()) {
				System.out.println("Un joueur joue son tour");
				this.plateau.placerCarte(i, 0, this.deck.piocher());
				i++;
			}
		}
		System.out.println("La partie se termine");
	}
	
	private void nouveauTour(){
		this.numTour++;
		this.deck = new Deck();
		this.plateau.resetPlateau();
		deck.piocher();
		System.out.println("Un nouveau tour est lancé");
	}

	// Exemple de partie ou les joueurs piochent et posent
	public static void main (String[] args){
		Partie partie = new Partie(3,1);
		partie.lancerPartie();
	}
}
