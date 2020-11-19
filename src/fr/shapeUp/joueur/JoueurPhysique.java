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
		System.out.print("\n");
		System.out.println("Poser la carte sur quelle colonne ? ");
		int ligne = saisiUseur.nextInt();
		System.out.println(ligne + "Quelle ligne ? ");
		int colonne = saisiUseur.nextInt();
		super.poserCarte(ligne - 1, colonne - 1);
		System.out.print("\n");
		System.out.println("Déplacer une carte ? Y/N ");
		String ouiOuNon = saisiUseur.next();
		if(ouiOuNon == "Y" || ouiOuNon == "y" ) {
			System.out.println("La carte est sur quelle colonne ? ");
			int ligneCarteADeplacer = saisiUseur.nextInt();
			System.out.println("La carte est sur quelle ligne ? ");
			int colonneCarteADeplacer = saisiUseur.nextInt();
			System.out.println("Poser la carte sur quelle colonne ? ");
			int newLigne = saisiUseur.nextInt();
			System.out.println("Quelle ligne ? ");
			int newColonne = saisiUseur.nextInt();
			super.deplacerCarte(ligneCarteADeplacer, colonneCarteADeplacer, newLigne - 1, newColonne - 1);
		}
		else {
			super.finTour();
		}

	}

	
}
