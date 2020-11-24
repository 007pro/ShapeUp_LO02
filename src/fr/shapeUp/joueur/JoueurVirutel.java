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
	

	@Override
	public void jouerTour() {
		//TODO supprimer le text quand il cherche une carte
		int i=0;
		boolean fonctionne;
			super.piocher();
			System.out.println("Joueur Virtuel joue");
			position = getPosition();
		     do {
		    	 fonctionne = super.poserCarte(partie.plateau.getClesValides().get(i));
		    	 i++;
		     }
		     while(fonctionne == false);
		     System.out.println("carte poser en " + partie.plateau.getClesValides().get(i-1) );
		     
		     super.finTour();			
	}
}