package fr.shapeUp.modele.partie;

import java.util.Random;



//Ceci est une carte !
/**
 * Création des cartes
 * 
 * @author Adrien Warnet, Vincent Diop
 *
 */
public class Carte {
	
	private contenu contenant;
	private formeCarte forme;
	private couleurCarte couleur;
	private boolean remplie;
	
	/**
	 * Enum de la forme de la carte
	 * @author Adrien Warnet, Vincent Diop
	 *
	 */
	public enum formeCarte {
		Carré,
		Rond,
		Triangle

	}
	
	/**
	 * Enum du contenu de la carte
	 * @author Adrien Warnet, Vincent Diop
	 *
	 */
	public enum contenu{
		Plein,
		Vide
		
	}
	
	/**
	 * Enum de la couleur de la carte
	 * @author Adrien Warnet, Vincent Diop
	 *
	 */
	public enum couleurCarte {
		Rouge,
		Vert,
		Bleu
	}
	
	/**
	 * Constructeur de la classe
	 * @param forme forme de la carte
	 * @param couleur couleur de la carte
	 * @param contenant contenu de la carte
	 */
	public Carte(formeCarte forme, couleurCarte couleur, contenu contenant){
		this.forme = forme;
		this.couleur = couleur;
		this.contenant = contenant;	
	}
	
	/**
	 * Constructeur par défault
	 */
	public Carte(){
		
	}
	
	/**
	 * Affiche la carte dans la console 
	 */
	public void afficherCarte() {
		System.out.print (this.couleur + " ");
		System.out.print (this.forme + " ");
		System.out.print (this.contenant + "       ");
	}
	
	/**
	 * @return la forme de la carte
	 */
	public formeCarte getForme() {
		return this.forme;
	}
	/**
	 * @return le contenu de la carte
	 */
	public contenu getContenu() {
		return this.contenant;
	}
	/**
	 * @return la couleur de la carte
	 */
	public couleurCarte getCouleur() {
		return this.couleur;
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
