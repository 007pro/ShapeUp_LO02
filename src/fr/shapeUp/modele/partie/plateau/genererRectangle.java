package fr.shapeUp.modele.partie.plateau;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Classe permettant de générer un plateau rectangulaire 
 * 
 * @author Adrien Warnet, Vincent Diop
 *
 */
public class genererRectangle implements genererClesStrategy {
	/**
	 * Génère la liste représentant le plateau
	 */
	@Override
	public ArrayList<String> generer(){
		ArrayList<String> cles = new ArrayList<String>();
		System.out.println("Veuillez indiquer la largeur puis la hauteur du plateau");
		int largeur = 5;
		int hauteur = 3;
		for(char ligneChar = 'A'; ligneChar < (65 + hauteur); ligneChar++) {
			for(int colonne = 0; colonne < largeur; colonne++) {
				cles.add(ligneChar + Integer.toString(colonne));
			}
		}
		Collections.sort(cles);
		return cles;
	}
}
