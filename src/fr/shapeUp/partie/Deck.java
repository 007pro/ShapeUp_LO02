package fr.shapeUp.partie;


import java.util.Random;
import java.util.Arrays;

import fr.shapeUp.partie.*;
import fr.shapeUp.partie.Carte.contenu;
import fr.shapeUp.partie.Carte.couleurCarte;
import fr.shapeUp.partie.Carte.formeCarte;

public class Deck {
	
	private int nbrCartes = 18;
	private Carte[] cartes;
	private int NB_ITERATIONS = 4;
	public Carte carteCourante;
	
	
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
	 
	 private void echanger(int i, int j)
	   {
	      Carte temp;
	      temp = this.cartes[i];
	      this.cartes[i] = this.cartes[j];
	      this.cartes[j] = temp;
	   }
	 
	 public int getNombreDeCartes()
	   {
	      return this.cartes.length;
	   }
	 
	 public Carte[] piocher(int n) // problème!! dans l'affichage il manque une carte c'est bizarre mais osef on peut dégager cette methode en vrai
	   {
		
	      if(n <= this.cartes.length)
	      {
	         Carte [] main = Arrays.copyOfRange(this.cartes, 0, n - 1);
	         this.cartes = Arrays.copyOfRange(this.cartes, n, this.cartes.length);
	         return main;
	      }
	     return null;
	   }
	 
	 public Carte piocher() {
		 
		 if (1<=this.cartes.length) {
			Carte[] carte1= this.cartes ;
			carteCourante = carte1[0];
			this.cartes = Arrays.copyOfRange(this.cartes, 1, this.cartes.length);
			return carteCourante;
		 }
		 return null;
	 }
	      
	 
//	 	public static void main (String[] args){
//			Deck deck = new Deck();
//			
//		System.out.println(deck.getNombreDeCartes());
//		Carte main = deck.piocher();
//		main.afficherCarte();
//		System.out.println(deck.getNombreDeCartes());
//		main = deck.piocher();
//		main.afficherCarte();

		// Affichage à l'aide d'une boucle forEach
		/*for(Carte elem: main)
		{
			elem.afficherCarte();
		}
		System.out.println(deck.getNombreDeCartes());*/
		
		
//	}


}
