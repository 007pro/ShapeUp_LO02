package fr.shapeUp.partie;

public class Plateau {
	private int hauteur;
	private int largeur;
	private Carte[][] cases;
	
	Plateau(int largeur, int hauteur){
		this.hauteur = hauteur;
		this.largeur = largeur;
	}
	
	public void placerCarte(int ligne, int colonne, Carte carte) {
		cases[ligne][colonne] = carte;
	}
	
	public Carte retirerCarte(int ligne, int colonne) {
		if(cases[ligne][colonne] != null) {
			Carte carteRetiree = new Carte();
			carteRetiree = cases[ligne][colonne];
			cases[ligne][colonne] = null;
			return carteRetiree;
		}
		return null;
	}
}
