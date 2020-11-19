package fr.shapeUp.partie;

public class Plateau {
	private int hauteur;
	private int largeur;
	private Carte[][] cases;
	private int casesLibres;
	
	Plateau(int largeur, int hauteur){
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.cases = new Carte[largeur][hauteur];
		this.casesLibres = hauteur*largeur;
	}
	
	public void resetPlateau(){
		this.cases = new Carte[this.largeur][this.hauteur];
		this.casesLibres = this.hauteur*this.largeur;
	}
	
	public boolean placerCarte(int ligne, int colonne, Carte carte) {
		if(0 <= ligne && ligne < this.largeur && 0 <= colonne && colonne < this.hauteur ) {
			if(this.cases[ligne][colonne] == null) {
				this.cases[ligne][colonne] = carte;
				this.casesLibres--;
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
				this.casesLibres++;
				return carteRetiree;
			}
		}
		return null;
	}
	
	public boolean rempli() {
		if(this.casesLibres == 0) {
			return true;
		}
		return false;
	}
}
