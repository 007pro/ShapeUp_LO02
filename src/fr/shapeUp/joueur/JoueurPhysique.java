package fr.shapeUp.joueur;

import fr.shapeUp.partie.Partie;
import java.util.Scanner;

/**
 * La classe joueur physique va permettre a l'utilisateur de jouer une partie 
 * 
 * @author Adrien Warnet, Vincent Diop
 * @version 1.0
 *
 */
public class JoueurPhysique extends Joueur {
	
	Scanner saisiUseur = new Scanner(System.in);

	public JoueurPhysique(Partie partie) {
		super(partie);
	}

	@Override
	public void jouerTour() {
		super.piocher();
		System.out.println("Poser la carte sur quelle ligne ? ");
		int ligne = saisiUseur.nextInt();
		System.out.println("Quelle colonne ? ");
		int colonne = saisiUseur.nextInt();
		super.poserCarte(ligne, colonne);
		System.out.println("Déplacer une carte ? Y/N ");
		String ouiOuNon = saisiUseur.next();
		if(ouiOuNon == "Y" || ouiOuNon == "y" ) {
			System.out.println("La carte est sur quelle ligne ? ");
			int ligneCarteADeplacer = saisiUseur.nextInt();
			System.out.println("La carte est sur quelle colonne ? ");
			int colonneCarteADeplacer = saisiUseur.nextInt();
			System.out.println("Poser la carte sur quelle ligne ? ");
			int newLigne = saisiUseur.nextInt();
			System.out.println("Quelle colonne ? ");
			int newColonne = saisiUseur.nextInt();
			super.deplacerCarte(ligneCarteADeplacer, colonneCarteADeplacer, newLigne, newColonne);
		}
		else {
			super.finTour();
		}

	}

}
