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
	public JoueurPhysique(Partie partie, int numJoueur, int typePartie) {
		super(partie, numJoueur,typePartie );
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
	
	@Override
	public void deplacerCarte() {

		System.out.println("vous allez d�placer une carte");
		Carte carteRetir�;
		boolean carteHere;
		do {
			System.out.println("La carte est � quelle position ? ");
			String positionCarteADeplacer = saisiUseur.nextLine();
			carteRetir� = partie.plateau.retirerCarte(positionCarteADeplacer);
			if (carteRetir� == null) {
				System.out.println("il n'y a pas de carte ici");
			}
		} while (carteRetir� == null);

		do {
			System.out.println("Poser la carte � quelle position ? ");
			String newPosition = saisiUseur.nextLine();
			carteHere = poserCarte(newPosition);
		} while (carteHere == false);

		
	}
	
	public boolean poserCarteOfMain(String position,int numCarte) {
		boolean cartePlac� = partie.plateau.placerCarte(position,this.mainCourante[numCarte -1]);//-1 car le joueur va dire carte 1,2 ou 3 et l'index commence en 0
		this.mainCourante[numCarte -1] = partie.deck.piocher();
		if (mainCourante[numCarte - 1] == null) {
			System.out.println("Le deck est vide");
		}
		if (cartePlac� == true) {
			System.out.println("Vous avez pos� votre carte en " + position);
			return true;
		} else if (cartePlac� == false) {
			System.out.println("il y a d�ja une carte ici");
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
			jouerTourClassique();
		}
		else {
			jouerTourAvanc�();
		}
		

	}
	

	@Override
	public void jouerTourAvanc�() {
		
		System.out.print("\n");
		System.out.println("Voulez-vous d'abord poser votre carte (1) ou en d�placer une (2) ?");
		int choix = saisiUseur.nextInt();
		saisiUseur.nextLine();
		if(choix == 1) {
			do { 
				afficherMain(this.mainCourante);
				System.out.println("Quelle carte souhaite-tu poser : (1,2)");
				int numCarte= saisiUseur.nextInt();
				saisiUseur.nextLine();
				System.out.println("Poser la carte � quelle position? ");
				String position = saisiUseur.nextLine();
				setPosition(position);
				pose = poserCarteOfMain(position, numCarte);
			} while (pose == false);
			System.out.print("\n");
			System.out.println("D�placer une carte ? 1=oui/2=non ");
	
			int ouiOuNon = saisiUseur.nextInt();
			saisiUseur.nextLine();
			if (ouiOuNon == 1) {
				deplacerCarte();
				super.setTourFini(true);
				System.out.println("Tour fini au suivant !");
	
			} else {
				super.setTourFini(true);
				System.out.println("Tour fini au suivant !");
			}
		} else {
			deplacerCarte();
			do { 
				afficherMain(this.mainCourante);
				System.out.println("Quelle carte souhaite-tu poser : (1,2)");
				int numCarte= saisiUseur.nextInt();
				saisiUseur.nextLine();
				System.out.println("Poser la carte � quelle position? ");
				String position = saisiUseur.nextLine();
				setPosition(position);
				pose = poserCarteOfMain(position, numCarte);
			} while (pose == false);
			System.out.print("\n");
			super.setTourFini(true);
		}
		
	}
	
	@Override
	public void jouerTourClassique() {
		super.piocher();
		System.out.print("\n");
		System.out.println("Voulez-vous d'abord poser votre carte (1) ou en d�placer une (2) ?");
		int choix = saisiUseur.nextInt();
		saisiUseur.nextLine();
		if(choix == 1) {
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
				deplacerCarte();
				super.finTour();
	
			} else {
				super.finTour();
			}
		}else {
			deplacerCarte();
			do {
				System.out.println("Poser la carte � quelle position? ");
				String position = saisiUseur.nextLine();
				setPosition(position);
				pose = poserCarte(position);
				} while (pose == false);
			System.out.print("\n");
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
