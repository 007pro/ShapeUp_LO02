package fr.utt.lo02.shapeUp.modele.joueur;

import java.util.Scanner;

import fr.utt.lo02.shapeUp.modele.partie.Carte;
import fr.utt.lo02.shapeUp.modele.partie.Partie;

/**
 * Classe fille de Joueur, permet � l'utilisateur de pouvoir jouer.
 * 
 * @author Adrien Warnet, Vincent Diop
 * @version 1.0
 *
 */
public class JoueurPhysique extends Joueur {

	/**
	 * Saisi utilisateur
	 */
	Scanner saisiUseur = new Scanner(System.in);
	/**
	 * Si c'est pos� ou pas 
	 */
	private boolean pose;
	/**
	 * si c'est d�plac� ou pas 
	 */
	private boolean deplace;

	/**
	 * Constructeur de la classe
	 * @param partie la partie en cours
	 * @param numJoueur le num�ro du joueur
	 * @param typePartie le type de partie 
	 */
	public JoueurPhysique(Partie partie, int numJoueur, int typePartie) {
		super(partie, numJoueur,typePartie );
	}

	
	/**
	 * D�claration de la m�thode poserCarte, pour un JoueurPhysique
	 */
	public boolean poserCarte(String position) {
		boolean cartePlac� = partie.getPlateau().placerCarte(position, this.carteCourante);

		if (cartePlac� == true) {
//			System.out.println("Vous avez pos� votre carte en " + position);
			return true;
		} else if (cartePlac� == false) {
			System.out.println("il y a d�ja une carte ici");
			return false;
		}

		return false;

	}
	
	/**
	 * Retire la carte que l'on veut d�placer
	 * @param positionCarteADeplacer la position de la carte
	 * @return
	 */
	public Carte deplacerCartePh1(String positionCarteADeplacer) {
		System.out.println("vous allez d�placer une carte");
		Carte carteRetir�;
		System.out.println("La carte est � quelle position ? ");
		carteRetir� = partie.getPlateau().retirerCarte(positionCarteADeplacer);
		if (carteRetir� == null) {
			System.out.println("il n'y a pas de carte ici");
		}
		return carteRetir�;	
	}
	
	/**
	 * Pose la carte que l'on � d�plac�
	 * @param carte Carte que l'on vas poser
	 * @param newPosition nouvelle position de la carte
	 * @return
	 */
	public boolean deplacerCartePh2(Carte carte, String newPosition) {
			boolean carteHere;
			System.out.println("Poser la carte � quelle position ? ");
			carteHere = partie.getPlateau().placerCarte(newPosition, carte);
			return carteHere;
	}
	
	/**
	 * Poser une carte de la main du joueur
	 * @param position position de la carte 
	 * @param numCarte num�ro de la carte que l'on veut poser
	 */
	public boolean poserCarteOfMain(String position,int numCarte) {
		boolean cartePlac� = partie.getPlateau().placerCarte(position,this.mainCourante[numCarte -1]);//-1 car le joueur va dire carte 1 ou 2 et l'index commence en 0
		this.mainCourante[numCarte -1] = partie.getDeck().piocher();
		if (mainCourante[numCarte - 1] == null) {
			System.out.println("Le deck est vide");
		}
		if (cartePlac� == true) {
			return true;
		} else if (cartePlac� == false) {
			System.out.println("il y a d�ja une carte ici");
			return false;
		}
		afficherMain(this.mainCourante);
		return false;
	}

	
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


	/**
	 * @return Le score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Pour modifier le score
	 * @param score 
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return La carte victoire
	 */
	public Carte getCarteVictoire() {
		return carteVictoire;
	}

	/**
	 * @return La carte en main
	 */
	public Carte getCarteCourante() {
		return carteCourante;
	}

	/**
	 * @return L'�tat de la main du joueur
	 */
	public boolean isCarteEnMain() {
		return carteEnMain;
	}

	/**
	 * @return L'�tat du tour 
	 */
	public boolean isTourFini() {
		return tourFini;
	}


	@Override
	public void deplacerCarte() {
		// TODO Auto-generated method stub
		
	}


	
	
}
