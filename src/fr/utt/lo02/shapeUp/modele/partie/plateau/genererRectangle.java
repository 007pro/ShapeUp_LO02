package fr.utt.lo02.shapeUp.modele.partie.plateau;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Classe permettant de g�n�rer un plateau rectangulaire 
 * 
 * @author Adrien Warnet, Vincent Diop
 *
 */
public class genererRectangle implements genererClesStrategy {
	/**
	 * G�n�re la liste repr�sentant le plateau
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
