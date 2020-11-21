package fr.shapeUp.joueur;

import fr.shapeUp.partie.Carte;
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
	private boolean pose;
	private boolean deplace;
	

	public JoueurPhysique(Partie partie, int numJoueur) {
		super(partie, numJoueur);
	}

	@Override
	public void jouerTour() {
		super.piocher();
		System.out.print("\n");
		do {
			System.out.println("Poser la carte à quelle position? ");
			String position = saisiUseur.nextLine();
			setPosition(position);
			pose = super.poserCarte(position);
		} while (pose == false);
		System.out.print("\n");
		System.out.println("Déplacer une carte ? 1=oui/2=non ");

		int ouiOuNon = saisiUseur.nextInt();
		if (ouiOuNon == 1) {
			do {
				System.out.println("La carte est à quelle position ? ");
				String positionCarteADeplacer = saisiUseur.nextLine();
				System.out.println("Poser la carte à quelle position ? ");
				String newPosition = saisiUseur.nextLine();
				deplace = super.deplacerCarte(positionCarteADeplacer, newPosition);
			} while (deplace == false);
		} else {
			super.finTour();
		}
		super.finTour();
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Carte getCarteVictoire() {
		return carteVictoire;
	}

	public Carte getCarteCourante() {
		return carteCourante;
	}

	public boolean isCarteEnMain() {
		return carteEnMain;
	}

	public boolean isTourFini() {
		return tourFini;
	}

	
}
