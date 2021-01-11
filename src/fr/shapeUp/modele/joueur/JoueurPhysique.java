package fr.shapeUp.modele.joueur;

import java.util.Scanner;

import fr.shapeUp.modele.partie.Carte;
import fr.shapeUp.modele.partie.Partie;

/**
 * Classe fille de Joueur, permet à l'utilisateur de pouvoir jouer.
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
	 * Si c'est posé ou pas 
	 */
	private boolean pose;
	/**
	 * si c'est déplacé ou pas 
	 */
	private boolean deplace;

	/**
	 * Constructeur de la classe
	 * @param partie la partie en cours
	 * @param numJoueur le numéro du joueur
	 * @param typePartie le type de partie 
	 */
	public JoueurPhysique(Partie partie, int numJoueur, int typePartie) {
		super(partie, numJoueur,typePartie );
	}

	
	/**
	 * Déclaration de la méthode poserCarte, pour un JoueurPhysique
	 */
	public boolean poserCarte(String position) {
		boolean cartePlacé = partie.getPlateau().placerCarte(position, this.carteCourante);

		if (cartePlacé == true) {
//			System.out.println("Vous avez posé votre carte en " + position);
			return true;
		} else if (cartePlacé == false) {
			System.out.println("il y a déja une carte ici");
			return false;
		}

		return false;

	}
	
	/**
	 * Retire la carte que l'on veut déplacer
	 * @param positionCarteADeplacer la position de la carte
	 * @return
	 */
	public Carte deplacerCartePh1(String positionCarteADeplacer) {
		System.out.println("vous allez déplacer une carte");
		Carte carteRetiré;
		System.out.println("La carte est à quelle position ? ");
		carteRetiré = partie.getPlateau().retirerCarte(positionCarteADeplacer);
		if (carteRetiré == null) {
			System.out.println("il n'y a pas de carte ici");
		}
		return carteRetiré;	
	}
	
	/**
	 * Pose la carte que l'on à déplacé
	 * @param carte Carte que l'on vas poser
	 * @param newPosition nouvelle position de la carte
	 * @return
	 */
	public boolean deplacerCartePh2(Carte carte, String newPosition) {
			boolean carteHere;
			System.out.println("Poser la carte à quelle position ? ");
			carteHere = partie.getPlateau().placerCarte(newPosition, carte);
			return carteHere;
	}
	
	/**
	 * Poser une carte de la main du joueur
	 * @param position position de la carte 
	 * @param numCarte numéro de la carte que l'on veut poser
	 */
	public boolean poserCarteOfMain(String position,int numCarte) {
		boolean cartePlacé = partie.getPlateau().placerCarte(position,this.mainCourante[numCarte -1]);//-1 car le joueur va dire carte 1 ou 2 et l'index commence en 0
		this.mainCourante[numCarte -1] = partie.getDeck().piocher();
		if (mainCourante[numCarte - 1] == null) {
			System.out.println("Le deck est vide");
		}
		if (cartePlacé == true) {
			return true;
		} else if (cartePlacé == false) {
			System.out.println("il y a déja une carte ici");
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
			jouerTourAvancé();
		}
		

	}
	

	@Override
	public void jouerTourAvancé() {
		
		System.out.print("\n");
		System.out.println("Voulez-vous d'abord poser votre carte (1) ou en déplacer une (2) ?");
		int choix = saisiUseur.nextInt();
		saisiUseur.nextLine();
		if(choix == 1) {
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
				System.out.println("Poser la carte à quelle position? ");
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
		System.out.println("Voulez-vous d'abord poser votre carte (1) ou en déplacer une (2) ?");
		int choix = saisiUseur.nextInt();
		saisiUseur.nextLine();
		if(choix == 1) {
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
				deplacerCarte();
				super.finTour();
	
			} else {
				super.finTour();
			}
		}else {
			deplacerCarte();
			do {
				System.out.println("Poser la carte à quelle position? ");
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
	 * @return L'état de la main du joueur
	 */
	public boolean isCarteEnMain() {
		return carteEnMain;
	}

	/**
	 * @return L'état du tour 
	 */
	public boolean isTourFini() {
		return tourFini;
	}


	@Override
	public void deplacerCarte() {
		// TODO Auto-generated method stub
		
	}


	
	
}
