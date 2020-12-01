package fr.shapeUp.partie;


import java.util.Random;
import java.util.Arrays;

import fr.shapeUp.partie.*;
import fr.shapeUp.partie.Carte.contenu;
import fr.shapeUp.partie.Carte.couleurCarte;
import fr.shapeUp.partie.Carte.formeCarte;

/**
 * Constitution du deck de plusieurs de carte
 * @author Adrien Warnet, Vincent Diop
 *
 */
public class Deck {
	
	private int nbrCartes = 18;
	private Carte[] cartes;
	private int NB_ITERATIONS = 4;
	public Carte carteCourante;
	
	
	/**
	 * Constructeur de la classe
	 */
	public Deck() {
		   // Initialisation des cartes du paquet.
	      this.cartes = new Carte[18];
	      for(int i = 0; i < couleurCarte.values().length; i++)
	      {
	         for(int j = 0; j < formeCarte.values().length; j++)
	         {
	        	 for (int e = 0 ; e < contenu.values().length; e++) {
	        		 
	        		 this.cartes[e + 2*j + 6*i] = new Carte(formeCarte.values()[j], couleurCarte.values()[i],contenu.values()[e]);
	        	 }
	           
	         }
	      }
	      // Mélange le jeu de cartes.
	         melanger();
	}
	
	 /**
	 * Mélange le deck
	 */
	private void melanger()
	   {
	      Random r = new Random();
	      for(int i = 0; i < NB_ITERATIONS; i++)
	      {
	         for(int j = 0; j < this.cartes.length; j++)
	         {
	            echanger(r.nextInt(this.cartes.length), r.nextInt(this.cartes.length));
	         }
	      }
	   }
	 
	 /**
	  * Permet d'echanger les carte de place utile pour mélanger
	 * @param i
	 * @param j
	 */
	private void echanger(int i, int j)
	   {
	      Carte temp;
	      temp = this.cartes[i];
	      this.cartes[i] = this.cartes[j];
	      this.cartes[j] = temp;
	   }
	 
	 /**
	 * @return le nombre de carte
	 */
	public int getNombreDeCartes()
	   {
	      return this.cartes.length;
	   }
	 
	 /**
	 * Piocher un nombre n de carte
	 * @param n nombre de carte
	 * @return la/les Carte
	 */
	public Carte[] piocher(int n) 
	   {
		
	      if(n <= this.cartes.length)
	      {
	         Carte [] main = Arrays.copyOfRange(this.cartes, 0, n);
	         this.cartes = Arrays.copyOfRange(this.cartes, n, this.cartes.length);
	         return main;
	      }
	     return null;
	   }
	 
	 /**
	 * Permet de piocher 1 carte 
	 * @return La carte
	 */
	public Carte piocher() {
		 
		 if (1<=this.cartes.length) {
			Carte[] carte1= this.cartes ;
			carteCourante = carte1[0];
			this.cartes = Arrays.copyOfRange(this.cartes, 1, this.cartes.length);
			return carteCourante;
		 }
		 return null;
	 }
	      
	 
	 	/*public static void main (String[] args){
			Deck deck = new Deck();
			
		System.out.println(deck.getNombreDeCartes());
		Carte[] main = deck.piocher(2);
		
		System.out.println(deck.getNombreDeCartes());
		

		// Affichage à l'aide d'une boucle forEach
		for(Carte elem: main)
		{
			elem.afficherCarte();
		}
		System.out.println(deck.getNombreDeCartes());
		
		
	 	}*/


}
