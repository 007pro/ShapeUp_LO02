package fr.shapeUp.joueur;

import fr.shapeUp.partie.Partie;
import fr.shapeUp.joueur.JoueurPhysique;

/**
 * La classe joueurVirtuel vas permettre à l'ordinateur de jouer contre un
 * joueurPhysique
 * 
 * @author Adrien Warnet, Vincent Diop
 * @version 1.0
 */
public class JoueurVirutel extends Joueur {

	boolean tourAutreJoueurFini;
	int ligne;
	int colonne;

	public JoueurVirutel(Partie partie, int numJoueur) {

		super(partie, numJoueur);

	}

	@Override
	public void jouerTour() {

//		tourAutreJoueurFini = isTourFini();
//		if (tourAutreJoueurFini == true) {
//			System.out.println("Joueur Virtuel joue");
//			ligne = getLigne()+1;
//			
//			if (ligne <5) {ligne = ligne-2;}
//			
//			boolean pose = poserCarte(ligne, colonne);
//			
//
//		}

	}

}