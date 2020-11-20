package fr.shapeUp.partie;

public class Plateau implements VComptage{
	private int hauteur;
	private int largeur;
	private Carte[][] cases;
	private int casesLibres;
	private boolean premCarte = true;
	
	Plateau(int largeur, int hauteur){
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.cases = new Carte[largeur][hauteur];
		this.casesLibres = hauteur*largeur;
	}
	
	public void resetPlateau(){
		this.cases = new Carte[this.largeur][this.hauteur];
		this.casesLibres = this.hauteur*this.largeur;
		this.premCarte = true;
	}
	
	public boolean placerCarte(int ligne, int colonne, Carte carte) {
		if(0 <= ligne && ligne < this.largeur && 0 <= colonne && colonne < this.hauteur ) {
			if(this.cases[ligne][colonne] == null) {
				int ligneMax;
				int colonneMax;
				int ligneMin;
				int colonneMin;
				if((ligne+1) == this.largeur) {ligneMax = ligne - 1;}
				else {ligneMax = ligne;}
				if((colonne+1) == this.hauteur) {colonneMax = colonne - 1;}
				else {colonneMax = colonne;}
				if(ligne == 0) {ligneMin = ligne + 1;}
				else {ligneMin = ligne;}
				if(colonne == 0) {colonneMin = colonne + 1;}
				else {colonneMin = colonne;}
				if(cases[ligneMin-1][colonne] != null || cases[ligne][colonneMin-1] != null || cases[ligneMax + 1][colonne] != null || cases[ligne][colonneMax + 1] != null || premCarte == true) {
					this.cases[ligne][colonne] = carte;
					this.casesLibres--;
					this.premCarte = false;
					return true;
				}
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
	
	public void afficherPlateau(){
		Carte carte;
		System.out.println("Voici le plateau :");
		System.out.print("\n\n");
		for(int i = 0; i < this.hauteur ; i++) {
			for(int j = 0; j < this.largeur; j++) {
				carte = this.cases[j][i];
				if(carte!=null) carte.afficherCarte();
				else System.out.print("     Rien            ");
			}
			System.out.print("\n");
		}
		System.out.print("\n\n");
	}
	
	public boolean rempli() {
		if(this.casesLibres == 0) {
			return true;
		}
		return false;
	}
	
	public void accept(CVisitor visitor) {
		visitor.visit(this);
	}
}
