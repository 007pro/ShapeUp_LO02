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
	
	
	/**
	 * Variable de contenu de la carte
	 */
	private contenu contenant;
	/**
	 * Variable de forme de la carte
	 */
	private formeCarte forme;
	/**
	 * Variable de couleur de la carte
	 */
	private couleurCarte couleur;
	
	
	/**
	 * Pour faire un affichage textuel de la carte lisible
	 */
	@Override
	public String toString() {
		return "" + contenant + " " + forme + " " + couleur;
	}
	
	/**
	 * Enum de la forme de la carte
	 * @author Adrien Warnet, Vincent Diop
	 *
	 */
	public enum formeCarte {
		Carre,
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
		Bleue
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
		System.out.print (this.contenant + " ");
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
	
}
