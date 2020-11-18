package fr.shapeUp.partie;

public class Plateau {
	private int hauteur;
	private int largeur;
	private Carte[][] cases;
	
	Plateau(int largeur, int hauteur){
		this.hauteur = hauteur;
		this.largeur = largeur;
	}
	
	public boolean placerCarte(int ligne, int colonne, Carte carte) {
		if(0 <= ligne && ligne < largeur && 0 <= colonne && colonne < hauteur ) {
			if(cases[ligne][colonne] == null) {
				cases[ligne][colonne] = carte;
				return true;
			}
		}
		return false;
	}
	
	public Carte retirerCarte(int ligne, int colonne) {
		if(0 <= ligne && ligne < largeur && 0 <= colonne && colonne < hauteur ) {
			if(cases[ligne][colonne] != null) {
				Carte carteRetiree = new Carte();
				carteRetiree = cases[ligne][colonne];
				cases[ligne][colonne] = null;
				return carteRetiree;
			}
		}
		return null;
	}
}
