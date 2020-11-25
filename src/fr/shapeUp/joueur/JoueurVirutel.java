package fr.shapeUp.joueur;

import fr.shapeUp.partie.Comptage;
import fr.shapeUp.partie.Partie;

import java.util.List;
import java.util.ArrayList;
import fr.shapeUp.joueur.JoueurPhysique;
import fr.shapeUp.partie.plateau.*;

/**
 * La classe joueurVirtuel vas permettre à l'ordinateur de jouer contre un
 * joueurPhysique
 * 
 * @author Adrien Warnet, Vincent Diop
 * @version 1.0
 */

public class JoueurVirutel extends Joueur {

	boolean tourAutreJoueurFini;
	String position;
	ArrayList<String> recupID = partie.plateau.getClesValides();

	public JoueurVirutel(Partie partie, int numJoueur) {
		super(partie, numJoueur);
	}

	public boolean poserCarte(String position) {
		boolean cartePlacé = partie.plateau.placerCarte(position, this.carteCourante);

		if (cartePlacé == true) {
			System.out.print("La carte posé est ");
			carteCourante.afficherCarte();
			System.out.println("\nest elle est posé en " + position);
			return true;
		} else if (cartePlacé == false) {
			return false;
		}

		return false;

	}

	@Override
	public void jouerTour() {

		int i = 0;
		boolean fonctionne;
		super.piocher();
		System.out.println("\nJoueur Virtuel joue");
		position = getPosition();
		do {
			fonctionne = poserCarte(partie.plateau.getClesValides().get(i));
			i++;
		} while (fonctionne == false);

		super.finTour();
	}
}