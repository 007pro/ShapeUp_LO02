package fr.shapeUp.partie;

import java.util.Random;



//Ceci est une carte !
public class Carte {
	
	private contenu contenant;
	private formeCarte forme;
	private couleurCarte couleur;
	private boolean remplie;
	
	public enum formeCarte {
		Carré,
		Rond,
		Triangle

	}
	public enum contenu{
		Plein,
		Vide
		
	}
	public enum couleurCarte {
		Rouge,
		Vert,
		Bleu
	}
	
	public Carte(formeCarte forme, couleurCarte couleur, contenu contenant){
		this.forme = forme;
		this.couleur = couleur;
		this.contenant = contenant;	
	}
	
	public Carte(){
		
	}
	//construteur avant les modif
	/*public Carte(formeCarte forme, couleurCarte couleur, boolean remplie){
		this.forme = forme;
		this.couleur = couleur;
		this.remplie = remplie;	
	}*/

	/*public Carte randomCarte() {
		int pick = new Random().nextInt(couleurCarte.values().length);
		int pick2 = new Random().nextInt(formeCarte.values().length);
	    Carte carteRandom = new Carte(formeCarte.values()[pick2],couleurCarte.values()[pick],new Random().nextBoolean());
	    return carteRandom;
	}*/

//	public static void main (String[] args){
//		Carte carte1 = new Carte().randomCarte();
//		System.out.print("Remplie :" + carte1.remplie);
//		System.out.print(" Couleur : " + carte1.couleur);
//		System.out.println(" Forme : " + carte1.forme);
//		Carte carte2 = new Carte().randomCarte();
//		System.out.print("Remplie :" + carte2.remplie);
//		System.out.print(" Couleur : " + carte2.couleur);
//		System.out.println(" Forme : " + carte2.forme);
//	}
}
