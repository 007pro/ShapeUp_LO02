package fr.shapeUp.joueur;

import fr.shapeUp.partie.Comptage;
import fr.shapeUp.partie.Partie;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import fr.shapeUp.joueur.JoueurPhysique;
import fr.shapeUp.partie.plateau.*;

/**
 * Classe fille de Joueur, joueu automatiquement.
 * 
 * @author Adrien Warnet, Vincent Diop
 * @version 1.0
 */

public class JoueurVirutel extends Joueur {

	boolean tourAutreJoueurFini;
	String position;
	ArrayList<String> recupID = partie.plateau.getClesValides();

	public JoueurVirutel(Partie partie, int numJoueur, int typePartie) {
		super(partie, numJoueur, typePartie);
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
		if (getTypePartie() == 1) {
			jouerTourClassique();
		}
		else {
			jouerTourAvancé();
		}
		
		
	}

	@Override
	public void jouerTourAvancé() {
		int i = 0;
		boolean fonctionne;
		int numCarte = 0;
		Random random = new Random();
		afficherMain(this.mainCourante);
		if (this.mainCourante[0] != null && this.mainCourante[1] != null) {
			numCarte = random.nextInt(2);
		}
		else if (this.mainCourante[0] == null) {
			numCarte = 1;
		}
		else if (this.mainCourante[1] == null) {
			numCarte = 0;
		}
		
		do {
			fonctionne = poserCarteOfMain(partie.plateau.getClesValides().get(i),numCarte);
			i++;
		} while (fonctionne == false);
		
		afficherMain(this.mainCourante);
	}

	@Override
	public void jouerTourClassique() {
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

	@Override
	public boolean poserCarteOfMain(String position, int numCarte) {
		boolean cartePlacé = partie.plateau.placerCarte(position,this.mainCourante[numCarte ]);
		this.mainCourante[numCarte] = partie.deck.piocher();
		if (mainCourante[numCarte] == null) {
			System.out.println("Le deck est vide");
		}
		if (cartePlacé == true) {
			System.out.println("Vous avez posé votre carte en " + position);
			return true;
		} 
		
		return false;
	}
}