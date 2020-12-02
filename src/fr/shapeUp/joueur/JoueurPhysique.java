package fr.shapeUp.joueur;

import fr.shapeUp.partie.Carte;
import fr.shapeUp.partie.Partie;
import java.util.Scanner;

/**
 * Classe fille de Joueur, permet à l'utilisateur de pouvoir jouer.
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
	 * @param numJoueur le numéro du joueur
	 */
	public JoueurPhysique(Partie partie, int numJoueur, int typePartie) {
		super(partie, numJoueur,typePartie );
	}

	
	/**
	 * Déclaration de la méthode poserCarte, pour un JoueurPhysique
	 */
	public boolean poserCarte(String position) {
		boolean cartePlacé = partie.plateau.placerCarte(position, this.carteCourante);

		if (cartePlacé == true) {
			System.out.println("Vous avez posé votre carte en " + position);
			return true;
		} else if (cartePlacé == false) {
			System.out.println("il y a déja une carte ici");
			return false;
		}

		return false;

	}
	
	public boolean poserCarteOfMain(String position,int numCarte) {
		//TODO transformer la main courante pour que la carte victoire ne soit pas dedans (je le modifi tout a l'heure)
		boolean cartePlacé = partie.plateau.placerCarte(position,this.mainCourante[numCarte -1]);//-1 car le joueur va dire carte 1,2 ou 3 et l'index commence en 0
		mainCourante[numCarte -1] = null;
		if (cartePlacé == true) {
			System.out.println("Vous avez posé votre carte en " + position);
			return true;
		} else if (cartePlacé == false) {
			System.out.println("il y a déja une carte ici");
			return false;
		}
		afficherMain(this.mainCourante);

		return false;
	}

	/**
	 * Tour d'un JoueurPhysique
	 */
	@Override
	public void jouerTour() {
		if (getTypePartie() == 1) {
			System.out.println("Nous jouons donc avec les regles classiques");
			jouerTourClassique();
		}
		else {
			System.out.println("Nous jouons donc avec les regles avancées");
			jouerTourAvancé();
		}
		

	}
	

	@Override
	public void jouerTourAvancé() {
		
		System.out.print("\n");
		do { 
			afficherMain(this.mainCourante);
			System.out.println("Quelle carte souhaite-tu poser : (1,2)");
			int numCarte= saisiUseur.nextInt();
			saisiUseur.nextLine();
			System.out.println("Poser la carte à quelle position? ");
			String position = saisiUseur.nextLine();
			setPosition(position);
			pose = poserCarteOfMain(position, numCarte);
		} while (pose == false);
		System.out.print("\n");
		System.out.println("Déplacer une carte ? 1=oui/2=non ");

		int ouiOuNon = saisiUseur.nextInt();
		saisiUseur.nextLine();
		if (ouiOuNon == 1) {
			super.deplacerCarte();
			super.ajoutCartEnMain();
			super.setTourFini(true);
			System.out.println("Tour fini au suivant !");

		} else {
			super.setTourFini(true);
			super.ajoutCartEnMain();
			System.out.println("Tour fini au suivant !");
		}
		
	}
	
	@Override
	public void jouerTourClassique() {
		super.piocher();
		System.out.print("\n");
		do {
			System.out.println("Poser la carte à quelle position? ");
			String position = saisiUseur.nextLine();
			setPosition(position);
			pose = poserCarte(position);
		} while (pose == false);
		System.out.print("\n");
		System.out.println("Déplacer une carte ? 1=oui/2=non ");

		int ouiOuNon = saisiUseur.nextInt();
		saisiUseur.nextLine();
		if (ouiOuNon == 1) {
			super.deplacerCarte();
			super.finTour();

		} else {
			super.finTour();
		}
		
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
