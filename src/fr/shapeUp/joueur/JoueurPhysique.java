package fr.shapeUp.joueur;

import fr.shapeUp.partie.Carte;
import fr.shapeUp.partie.Partie;
import java.util.Scanner;

/**
 * Classe fille de Joueur, permet � l'utilisateur de pouvoir jouer.
 * 
 * @author Adrien Warnet, Vincent Diop
 * @version 1.0
 *
 */
public class JoueurPhysique extends Joueur {

	Scanner saisiUseur = new Scanner(System.in);
	private boolean pose;
	private boolean deplace;

	/**
	 * Constructeur de la classe
	 * @param partie la partie encore
	 * @param numJoueur le num�ro du joueur
	 */
	public JoueurPhysique(Partie partie, int numJoueur) {
		super(partie, numJoueur);
	}

	
	/**
	 * D�claration de la m�thode poserCarte, pour un JoueurPhysique
	 */
	public boolean poserCarte(String position) {
		boolean cartePlac� = partie.plateau.placerCarte(position, this.carteCourante);

		if (cartePlac� == true) {
			System.out.println("Vous avez pos� votre carte en " + position);
			return true;
		} else if (cartePlac� == false) {
			System.out.println("il y a d�ja une carte ici");
			return false;
		}

		return false;

	}
	
	public boolean poserCarteOfMain(String position,int numCarte) {
		//TODO transformer la main courante pour que la carte victoire ne soit pas dedans (je le modifi tout a l'heure)
		boolean cartePlac� = partie.plateau.placerCarte(position,mainCourante[numCarte -1]);//-1 car le joueur va dire carte 1,2 ou 3 et l'index commence en 0
		mainCourante[numCarte -1]= null;
		if (cartePlac� == true) {
			System.out.println("Vous avez pos� votre carte en " + position);
			return true;
		} else if (cartePlac� == false) {
			System.out.println("il y a d�ja une carte ici");
			return false;
		}

		return false;
	}

	/**
	 * Tour d'un JoueurPhysique
	 */
	@Override
	public void jouerTourClassique() {
		super.piocher();
		System.out.print("\n");
		do {
			System.out.println("Poser la carte � quelle position? ");
			String position = saisiUseur.nextLine();
			setPosition(position);
			pose = poserCarte(position);
		} while (pose == false);
		System.out.print("\n");
		System.out.println("D�placer une carte ? 1=oui/2=non ");

		int ouiOuNon = saisiUseur.nextInt();
		saisiUseur.nextLine();
		if (ouiOuNon == 1) {
			super.deplacerCarte();
			super.finTour();

		} else {
			super.finTour();
		}

	}
	

	@Override
	public void jouerTourAvanc�() {
		super.piocherMainde3();
		System.out.print("\n");
		
		
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
