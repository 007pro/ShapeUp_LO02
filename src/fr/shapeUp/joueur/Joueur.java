package fr.shapeUp.joueur;
/**
 * La classe joueur qui vas �tre la classe d'origine des classes joueurVirtuel et JoueurPhysique
 * Elle est d�fini en classe abstraite car on n'est pas sens� pouvoir l'instancier.
 * 
 * @author Adrien Warnet, Vincent Diop 
 * @version 1.0
 * 
 */
public abstract class Joueur {

	/**
	 * score, vas repr�senter le score du joueur
	 */
	private int score = 0;
	
	//private Carte carteVictoire = new carte();
	private String carteVictoire ; // en attandant la cr�ation de la classe carte je fais un string pour simuler
	private int carte; //la carte qu'il � dans la main et qu'il vas jouer simuler en int pour l'instant
	
	public Joueur() {
		this.score = 0;
		this.carteVictoire = "carte victoire al�atoire"; 
		this.carte = 0;
		
	}
	
	public abstract void jouerTour();
	
	public void poserCarte (String carte, int position) {
		
	}
	
	public void deplacerCarte(String carte, int newPosition) {
		
	}
	
	public void piocher() {
		//et avec un enum de cartes on pourra dire qu'il utilse � pioch� cette carte 
		this.carte = (int) (Math.random() * ( 14 - 0 ));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("xesh");
		
	}
}
